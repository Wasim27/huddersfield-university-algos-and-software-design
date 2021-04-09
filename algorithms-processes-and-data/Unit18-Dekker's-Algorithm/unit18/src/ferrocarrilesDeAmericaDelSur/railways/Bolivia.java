package ferrocarrilesDeAmericaDelSur.railways;

import ferrocarrilesDeAmericaDelSur.errors.RailwaySystemError;
import ferrocarrilesDeAmericaDelSur.errors.SetUpError;
import ferrocarrilesDeAmericaDelSur.tools.Clock;
import ferrocarrilesDeAmericaDelSur.tools.Delay;

/**
 * An implementation of a railway.  The runTrain method, should, in collaboration with Peru's runTrain(), guarantee
 * safe joint operation of the railways.
 */
public class Bolivia extends Railway {
	/**
	 * Change the parameters of the Delay constructor in the call of the superconstructor to
	 * change the behaviour of this railway.
	 *
	 * @throws SetUpError if there is an error in setting up the delay.
	 */
	public Bolivia() throws SetUpError {
		super("Bolivia", new Delay(0.1, 0.3));
	}

	/**
	 * Run the train on the railway.
	 * This method provides synchronisation to avoid two trains being in the pass at the same time.
	 */
	public void runTrain() throws RailwaySystemError {
		Clock clock = getRailwaySystem().getClock();
		Railway peruRailway = getRailwaySystem().getNextRailway(this);
		while (!clock.timeOut()) {
			choochoo();
			this.getBasket().putStone(this);

			while(!getSharedBasket().hasStone(peruRailway)) {
				if (peruRailway.getBasket().hasStone(peruRailway)) {
					this.getBasket().takeStone(this);
					while (!getSharedBasket().hasStone(this)) {
						siesta();
					}
					this.getBasket().putStone(this);
				}
			}
			crossPass();
			getSharedBasket().takeStone(this);
			getBasket().takeStone(this);
		}
	}
}






















