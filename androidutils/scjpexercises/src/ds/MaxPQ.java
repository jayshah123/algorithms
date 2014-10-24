package ds;

import java.util.Comparator;
import java.util.NoSuchElementException;

//heap ordered binary tree(stored as array) backing priority queue
public class MaxPQ<Key> {

	private Key[] pq;// pq[0] is unused
	private int N;//pq[N] holds the last added item
	private Comparator<Key> comparator; // optional Comparator

	// create a empty priority queue
	public MaxPQ() {
		this(1);
	}

	// build priority queue with capacity
	public MaxPQ(int capacity) {
		pq = (Key[]) new Object[capacity + 1];
		N = 0;
	}

	/**
	 * Initializes an empty priority queue with the given initial capacity,
	 * using the given comparator.
	 * 
	 * @param initCapacity
	 *            the initial capacity of the priority queue
	 * @param comparator
	 *            the order in which to compare the keys
	 */
	public MaxPQ(int initCapacity, Comparator<Key> comparator) {
		this.comparator = comparator;
		pq = (Key[]) new Object[initCapacity + 1];
		N = 0;
	}

	/**
	 * Initializes an empty priority queue using the given comparator.
	 * 
	 * @param comparator
	 *            the order in which to compare the keys
	 */
	public MaxPQ(Comparator<Key> comparator) {
		this(1, comparator);
	}

	/**
     * Initializes a priority queue from the array of keys.
     * Takes time proportional to the number of keys, using sink-based heap construction.
     * @param keys the array of keys
     */
    public MaxPQ(Key[] keys) {
        N = keys.length;
        pq = (Key[]) new Object[keys.length + 1]; 
        for (int i = 0; i < N; i++)
            pq[i+1] = keys[i];
        for (int k = N/2; k >= 1; k--)
            sink(k);
        assert isMaxHeap();
    }

	// insert a key in the priority queue
	/*
	 * Insert. We add the new item at the end of the array, increment the size
	 * of the heap, and then swim up through the heap with that item to restore
	 * the heap condition.
	 */

	public void insert(Key v) {
		// double size of array if necessary
		if (N >= pq.length - 1)
			resize(2 * pq.length);

		// add x, and percolate it up to maintain heap invariant
		pq[++N] = v;
		swim(N);
		assert isMaxHeap();

	}

	// return the largest key
	public Key max() {
		if (isEmpty())
			throw new NoSuchElementException("Priority queue underflow");
		return pq[1];
	}

	/*
	 * We take the largest item off the top, put the item from the end of the
	 * heap at the top, decrement the size of the heap, and then sink down
	 * through the heap with that item to restore the heap condition
	 */
	public Key delMax() {
		if (isEmpty())
			throw new NoSuchElementException("Priority queue underflow");
		Key max = pq[1];
		exch(1, N--);
		sink(1);
		pq[N + 1] = null;
		if ((N > 0) && (N == (pq.length - 1) / 4))
			resize(pq.length / 2);
		return max;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	// swim operation
	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k, k / 2);
			k = k / 2;
		}
	}

	// sink operation
	private void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(j, j + 1))
				j++;
			if (!less(k, j))
				break;
			exch(k, j);
			k = j;
		}
	}

	private boolean less(int i, int j) {
		if (comparator == null) {
			return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
		} else {
			return comparator.compare(pq[i], pq[j]) < 0;
		}
	}

	private void exch(int i, int j) {
		Key swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
	}

	// helper function to double the size of the heap array
	private void resize(int capacity) {
		assert capacity > N;
		Key[] temp = (Key[]) new Object[capacity];
		for (int i = 1; i <= N; i++)
			temp[i] = pq[i];
		pq = temp;
	}

	// is pq[1..N] a max heap?
	private boolean isMaxHeap() {
		return isMaxHeap(1);
	}

	// is tree rooted at k a max heap?
	private boolean isMaxHeap(int k) {
		if (k > N) return true;
        int left = 2*k, right = 2*k + 1;
        if (left  <= N && less(k, left))  return false;
        if (right <= N && less(k, right)) return false;
        return isMaxHeap(left) && isMaxHeap(right);
	}

}
