import ArrayList.DynamicList;

public class Driver
{
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		DynamicList<Integer> list = new DynamicList<Integer>();
		list.add(2);
		list.add(4);
		list.add(5);
		list.add(6);
		list.print();
		list.remove(2);
		list.print();
		list.add(2);
		list.print();
		list.add(2,10);list.add(2,10);list.add(2,10);list.add(2,10);list.add(2,10);list.add(2,10);list.add(2,10);list.add(2,10);list.add(2,10);
		list.print();
		list.removeAll(10);
		list.print();
		list.removeAll(9);
		list.print();
		list.removeAll(2);
		list.print();
		list.clear();
		list.print();
	}
}
