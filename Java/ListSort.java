package sort;

public class ListSort extends Sort
{
	public int[] sort(int[] list)
	{
		int max = 0;
		int smallest = list[0];
		for (int counter = 0; counter < list.length; counter++)
		{
			if (list[counter] > max)
			{
				max = list[counter];
			}
			if (list[counter] < smallest)
			{
				smallest = list[counter];
			}
		}
		int offset = smallest;
		return sort(list, max + 1, offset);
	}

	public int[] sort(int[] list, int max, int offset)
	{
		max++;
		int[] f = new int[max];
		for (int counter = 0; counter < list.length; counter++)
		{
			f[list[counter] - offset]++;
		}

		int latest = 0;
		for (int counter = 0; counter < max - offset; counter++)
		{
			if (f[counter] != 0)
			{
				for (int counter2 = 0; counter2 < f[counter]; counter2++)
				{
					list[latest] = counter + offset;
					latest++;
				}
			}
		}
		return list;
	}
}
