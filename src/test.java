
public class test {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Queue<Integer> t = ImmutableQueueImpl.getEmptyQueue();

		try {
			t.enQueue(1);
			print(t);
			t.enQueue(2);
			print(t);
			t = t.enQueue(null);
			print(t);
			t = t.enQueue(60);
			print(t);
			t = t.deQueue();
			print(t);
			t = t.deQueue();
			print(t);

		} catch (Exception e) {

			e.printStackTrace();
		}


	}
	private static void print(Queue<Integer> q) throws Exception{
		while(q != null && !q.isEmpty()){
			System.out.print(q.head() + " -> ");
			q = q.deQueue();
		}
		System.out.println();
	}
}
