package resourceManager;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockResourceManager extends BasicResourceManager {

    final Lock lock = new ReentrantLock();
    final Condition[] priorityValue = new Condition[11];
    private boolean inUse = false;

    /**
     *
     * @param resource the resource managed by this manager
     * @param maxUses  the maximum number of uses permitted for this manager's resource.
     */
    public LockResourceManager(Resource resource, int maxUses) {
        super(resource, maxUses);
        for(int i=0; i<priorityValue.length; i++) {
            priorityValue[i] = lock.newCondition();
        }
    }

    @Override
    public void requestResource(int priority) throws ResourceError {
        lock.lock();
        try {
            while(inUse) {
                increaseNumberWaiting(priority);
                priorityValue[priority].await();
            }
            inUse = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int releaseResource() throws ResourceError {
        lock.lock();
        try {
            for(int i = 10; i >= 0; i--) {
                if(getNumberWaiting(i) > 0) {
                    decreaseNumberWaiting(i);
                    priorityValue[i].signal();
                    return i;
                }
            }
            return NONE_WAITING;
        } finally {
            inUse = false;
            lock.unlock();
        }
    }
}
