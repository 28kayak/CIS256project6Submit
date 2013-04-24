
class Heap<E extends Comparable <E>>
{
	  private Patient[] elements;//Array that hold heap elements
	  private int lastIndex;
	  private int maxIndex;

	  public Heap(int maxSize)
	  {
	  	elements = new Patient[maxSize + 1];
	  	lastIndex = 0;
	 	maxIndex = maxSize;
	  	elements[0] = new Patient("","", -1);
	  }//Heap
	  public boolean isEmpty()
	  {
	  	return (lastIndex == 0);
	  }//isEmpty()
	  public boolean isFull()
	  {
	  	return (lastIndex == maxIndex);
	  }//isFull()
	  public void add(Patient item)
	  {
	  	if(isFull())
	  	{
	  		throw new PriQOverflowException("---This Heap is full---");
	  	}
	  	else 
	  	{
	  		lastIndex++;
	  		elements[lastIndex] = item;
	  		
	  		//System.out.println("ADD"+elements[lastIndex].toString());
	  		upTrade(lastIndex);
	  		//System.out.println("ADD2"+elements[lastIndex].toString());
	  	}
	  }//add()
	  public Patient remove()
	  {
	  	Patient dequeue;
	  	if(isEmpty())
	  	{
	  		throw new PriQunderflowException("---This heap is Empty---");
	  	}
	  	else
	  	{
	  		dequeue = elements[1];//since prioritized queue, root is always removed
	  		elements[1] = elements[lastIndex];
	  		lastIndex--;
	  		downTrade(1);
	  	}
	  	return dequeue;
	  }//remove()
	  public String toString()
	  {
	  	String theHeap = new String("the heap is \n");
	  	System.out.println("--inside of toString--");
	  	for(int index = 1; index <= lastIndex; index++)
	  	{
	  		theHeap = theHeap + index + ". " + elements[index] + "\n";
	  	}
	  	return theHeap;
	  }//toString
	  public void upTrade(int index)
	  {
	  	Patient temp;
	  	//System.out.printf("index = %d", index);

	  	int currentElementPriority = elements[index].getPriority();
	  	int parentElementPriority = elements[index/2].getPriority();

	  	if((currentElementPriority > parentElementPriority) && index != 1)
	  	{
	  		temp = elements[index];
	  		elements[index] = elements[index/2];
	  		elements[index/2] = temp;
	  		upTrade(index/2);
	  	}
	  	else
	  	{
	  		//nothing to do
	  	}
	  }//upTrade()
	  public void downTrade(int index)
	  {
	  	Patient temp;
	  	if((2* index+1) <= lastIndex)
	  	{//there are 2 children
	  		if(elements[2*index].getPriority() > elements[index].getPriority())
	  		{
	  			temp = elements[index];
	  			elements[index] = elements[index * 2];
	  			elements[index * 2] = temp;
	  			downTrade(2*index + 1);
	  		}

	  	}
	  	else if((2 * index) == lastIndex)
	  	{//there is only left side child
	  	if(elements[2*index].getPriority() > elements[index].getPriority())
	  	{
	  		temp = elements[index];
  			elements[index] = elements[index * 2];
  			elements[index * 2] = temp;
		}
	  	}else if(2 * index > lastIndex)
	  	{
	  		
	  		//System.out.println("2index > lastIndex");
	  		
	  	}
	  	else
	  	{
	  		System.out.println("--Exception--");
	  	}
	  }//downTrade()

}//class