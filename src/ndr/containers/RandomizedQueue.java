package ndr.containers;
import java.util.Iterator;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {

	private Item[] data;
	private int size = 0;
	private Random generator;
	private void resize(int N) {
		Item[] array = (Item[]) new Object[N];
		for (int i = 0; i < size; i++)
			array[i] = data[i];
		data = array;
		generator = new Random();
	}

	public RandomizedQueue() {
		data = (Item[]) new Object[1];
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void enqueue(Item item) {
		if (item == null)
			throw new java.lang.NullPointerException();
		if (size == data.length)
			resize(data.length * 2 );
		data[size++] = item;
	}

	public Item dequeue() {
		if (isEmpty())
			throw new java.util.NoSuchElementException();
		int id = generator.nextInt(size);
		Item ans = data[id];
		data[id] = data[size - 1];
		data[size - 1] = null;
		size--;
		if (size > 0 && size == data.length/4)
			resize(data.length/2);
		return ans;
	}

	public Item sample() {
		if (isEmpty())
			throw new java.util.NoSuchElementException();
		
		int id = generator.nextInt(size);
		return data[id];
	}

	private Item[] copy() {
		if (isEmpty())
			return null;
		Item[] ans = (Item[]) new Object[size];
		for (int i = 0; i < size; i++)
			ans[i] = data[i];
		
		shuffle( ans );
		return ans;
	}
    public void shuffle(Object[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = i + generator.nextInt(N-i);     // between i and N-1
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
	@Override
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			private Item data[] = copy();
			private int id = 0;
			@Override
			public boolean hasNext() {
				return id < data.length;
			}

			@Override
			public Item next() {
				if( id == data.length ) throw new java.util.NoSuchElementException();
				return data[id++];
			}

			@Override
			public void remove() {
				throw new java.lang.UnsupportedOperationException();
			}
		};
	}

}
