Requirements

1. As a user I can add an warehouse

2. As a user I can add itens to a warehouse

3. As a user I can increment/decrement the amount of itens

Test cases

Test 1: Current amount=120, Operation=Increment, Operation Amount=50, Negative Amount Allowed=indiferent
Expected: Current amount=170

Test 2: Current amount=1, Operation=Decrement, Operation Amount=5, Negative Amount Allowed=true
Expected=Current amount = -4

Test 3: Current amount=1, Operation=Decrement, Operation Amount=5, Negative Amount Allowed=false
Expected=Error, current amount is not enough.


4. As a user I can track when the amount of an item is incremented/decremented

Test 1: Current amount=120, Operation=Increment, Operation Amount=50, Negative Amount Allowed=indiferent,Message=Received from invoice #987656
Expected: Current amount=170, Operation registered with Current Date, Operation=Increment, Amount=50,Message=Received from invoice #987656

Test 1: Current amount=120, Operation=Decrement, Operation Amount=1, Negative Amount Allowed=indiferent,Message=Order #234
Expected: Current amount=170, Operation registered with Current Date, Operation=Increment, Amount=50,Message=Received from invoice #987656

5. As a user I can transfer an amount of itens from one warehouse to another.

Test 1: when transfer from W1 to W2 the system shoud do two operations: one decrement in the source e one increment in the destination. The track should register two operations too.

