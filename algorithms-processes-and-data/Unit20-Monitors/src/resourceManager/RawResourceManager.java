package resourceManager;

public class RawResourceManager extends BasicResourceManager{
    private int[] waiting = new int[NO_OF_PRIORITIES];
    private int currentPriority = 0;
    private boolean inUse = false;

    /**
     * Set the resource and initialise the numbers of waiting processes, and the number of users, to zero.
     *
     * @param resource the resource managed by this manager
     * @param maxUses  the maximum number of uses permitted for this manager's resource.
     */
    public RawResourceManager(Resource resource, int maxUses) {
        super(resource, maxUses);
    }

    @Override
    public synchronized void requestResource(int priority) throws ResourceError {
        try {
            waiting[priority]++;
            while (priority < currentPriority || inUse) {
                wait();
            }
            if (currentPriority < priority) currentPriority = priority;
            waiting[priority]--;
            inUse = true;
        }
        catch (InterruptedException e){
            throw new ResourceError(e.getMessage());
        }
    }

    @Override
    public synchronized int releaseResource() throws ResourceError {
        for(int i=10; i >=0; i--){
            if(waiting[i]>0){
                currentPriority=i;
                break;
            }
        }
        inUse = false;
        notifyAll();
        return currentPriority;
    }
}