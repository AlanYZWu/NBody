/**********************************************************************
 *  N-Body Simulation readme.txt template
 **********************************************************************/


Name: Alan Wu
PennKey: wualan
Hours to complete assignment (optional): Around 4



/**********************************************************************
 *  Please list all help, collaboration, and outside resources
 *  you used here. 
 *
 *  If you did not get any help in outside of TA office hours,
 *  and did not use any materials outside of the standard
 *  course materials and piazza, write the following statement below:
 *  "I did not receive any help outside of TA office hours.  I
 *  did not collaborate with anyone, and I did not use any
 *  resources beyond the standard course materials."
 **********************************************************************/

I used the documentation for the Math class because I wanted to take the square
root of a some values and I took AP Computer Science in high school and we used the 
Math class a bit so I knew that the Math class had a method that took square roots,
but I didn't remember what it was exactly so I checked the documentation.

Here's the link to what I used: 
https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html

/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/

It took a lot of debugging to get the vertical values to update correctly. 
That took aroundhalf of my time to figure out what wasn't working with my program. 
I was getting 0, NaN, and Infinity a lot for the vertical position and velocity, but
I realized that I was writing something like py[i] - py[i] instead of py[j] - py[i],
or something else along those lines.


/**********************************************************************
 *  If you created your own universe for extra credit, describe it
 *  here and why it is interesting.
 **********************************************************************/



/**********************************************************************
 *  List any other comments here.                                     
 **********************************************************************/