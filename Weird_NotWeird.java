//WEIRD OR NOT WEIRD NUMBER
package Program_100;
import java.util.ArrayList;
import java.util.List;
public class Weird_NotWeird {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		for(int count = 1; count <= 25; n += 2)
		{
			if(isWeird(n))
			{
				System.out.printf("Weird(%d) = %d%n",count,n);
				count++;
			}
		}
	}
	private static boolean isWeird(int n)
	{
		List<Integer> properDivisors = getProperDivisors(n);
		return isAbudant (properDivisors, n) && ! isSemiPerfect(properDivisors,n);
	}
	private static boolean isAbudant(List<Integer> divisors, int n)
	{
		int divisorSum = divisors.stream().mapToInt(i->i.intValue()).sum();
		return divisorSum > n;
	}
	private static boolean isSemiPerfect(List<Integer> divisors, int sum)
	{
		int size = divisors.size();
		boolean subset[][]=new boolean [sum+1][size+1];
		for(int i=0;i<=size;i++)
		{
			subset[0][i]=true;
		}
		for(int i=1;i<=sum;i++)
		{
			subset[i][0]=false;
		}
		for(int i=1;i<=sum;i++)
		{
			for(int j=1;j<=size;j++)
			{
				subset[i][j]=subset[i][j-1];
				int test=divisors.get(j-1);
				if(i >= test)
				{
					subset[i][j]=subset[i][j] || subset[i-test][j-1];
				}
			}
		}
		return subset[sum][size];
	}
	private static final List<Integer> getProperDivisors(int number)
	{
		List<Integer> divisors = new ArrayList<Integer>();
		long sqrt = (long) Math.sqrt(number);
		for(int i=1;i<=sqrt;i++)
		{
			if(number % i == 0)
			{
				divisors.add(i);
				int div = number/i;
				if(div != i && div != number)
				{
					divisors.add(div);
				}
			}
		}
		return divisors;
	}
}
