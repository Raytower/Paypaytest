import java.util.Collections;
import java.util.NoSuchElementException;

public final class ImmutableQueueImpl<T> implements Queue<T> {

	private final Stack<T> forward;                            //forward queue
    private final Stack<T> backward;                           //backward queue

	private ImmutableQueueImpl(Stack<T> forward,Stack<T> backward) {
		this.forward = forward;
		this.backward = backward;

	}

	// Reverse mothed
	@SuppressWarnings("unchecked")
	public final static Stack reverse(Stack st) throws Exception{
		@SuppressWarnings("rawtypes")
		Stack s = ImmutableStackImpl.getEmptyinstance();
		if(st.isEmpty()!=true) {
			s = s.push(st.head());
			st = st.pop();
		}
		return s;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final static Queue getEmptyQueue() {
		return EmptyQueue.getInstance();
	}

	public final Queue<T> enQueue(T t) {

		return new ImmutableQueueImpl<T>(forward,backward.push(t));
	}

	@SuppressWarnings("unchecked")
	@Override
	public final Queue<T> deQueue() {

		Stack<T> t = null;
		try {
			t = forward.pop();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (!t.isEmpty()){
            return new ImmutableQueueImpl<T>(t, backward);
        }
        else if (backward.isEmpty()){
            return ImmutableQueueImpl.getEmptyQueue();
        }
        else {
            try {
				return new ImmutableQueueImpl<T>(ImmutableQueueImpl.reverse(backward), ImmutableStackImpl.getEmptyinstance());
			} catch (Exception e) {
				e.printStackTrace();
				return ImmutableQueueImpl.getEmptyQueue();
			}
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public final T head() {
		try {
			return forward.head();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return (T) Collections.emptyList();
		}
	}

	@Override
	public boolean isEmpty() {

		return false;
	}

	private static final class EmptyQueue<T> implements Queue<T>{
		@SuppressWarnings("rawtypes")
		private final static EmptyQueue empty  = new EmptyQueue();

		public final static EmptyQueue getInstance() {
			return empty;
		}

		@SuppressWarnings("unchecked")
		@Override
		public final Queue<T> enQueue(T t) {

			return new ImmutableQueueImpl<T>(ImmutableStackImpl.getEmptyinstance().push(t),ImmutableStackImpl.getEmptyinstance());
		}

		@Override
		public Queue<T> deQueue() {

			 throw new NoSuchElementException();
		}

		@Override
		public T head() {

			 throw new NoSuchElementException();
		}

		@Override
		public boolean isEmpty() {

			return true;
		}


	}


}
