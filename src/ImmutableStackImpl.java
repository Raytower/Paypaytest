
public final class ImmutableStackImpl<T> implements Stack<T> {
	
	private final T head;
	private final Stack<T> tail;
	
	private ImmutableStackImpl(T head,Stack<T> tail) {
		this.head = head;
		this.tail = tail;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Stack<T> push(T t) {
		
		return new ImmutableStackImpl(t,this);
	}

	@Override
	public Stack<T> pop() throws Exception {
		
		return tail;
	}

	@Override
	public T head() throws Exception {
		
		return head;
	}
	
	public final static Stack getEmptyinstance() {
		
		return ImmutableEmptyStack.getInstance();
	}
	
	@Override
	public boolean isEmpty() {
		
		return false;
	}
	private static final class ImmutableEmptyStack<T> implements Stack<T>{
		
		@SuppressWarnings("rawtypes")
		private final static ImmutableEmptyStack emptyStack = new ImmutableEmptyStack();
		
		public final static ImmutableEmptyStack getInstance() {
			return emptyStack;
		}
		
		@Override
		public Stack<T> push(T t) {
			
			return new ImmutableStackImpl<T>(t,this);
		}

		@Override
		public Stack<T> pop() throws Exception {
			
			throw new Exception("stack is empty");
		}

		@Override
		public T head() throws Exception {
			
			throw new Exception("stack is empty");
		}

		@Override
		public boolean isEmpty() {
			
			return true;
		}
		
	}
}
