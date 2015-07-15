package sound_lab;

public class Sound {
	
	// the array of values in this sound; guaranteed not to be null
	private int [] samples;
	
	// changes those values in this sound that have an amplitude greater than
	// limit.
	// values greater than limit are changed to limit.
	// values less than -limit are changed to -limit
	// @param: limit - the amplitude limit
	//		PRECONDITION: limit >= 0
	// @return: the number of values in this sound that this method changed
	public int limitAmplitude (int limit) {
		// to be implemented in part (a)
	}
	
	// removes all silence from the beginning of this sound
	// silence is represented by a value of 0
	// PRECONDITION: samples contains at least one nonzero value
	// POSTCONDITION: the length of samples reflects the removal of starting
	//                silence
	public void trimSilenceFromBeginning() {
		// to be implemented in part (b)
	}

}
