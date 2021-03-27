To solve this problem, consider the following algorithms:
- NFA (Next Fit Algorithm) - algorithm "filling the next";
- FFA (First Fit Algorithm) - algorithm "filling the first suitable";
- WFA (Worst Fit Algorithm) - algorithm for filling the "least complete";
- BFA (Best Fit Algorithm) - algorithm for filling the "best".

Algorithm for "filling the next"

The simplest algorithm, which in most cases gives the worst results. Its advantage is that it requires the least number of comparison operations.
1) We take a new element.
2) We take a new container.
3) Put the element in a container.
4) Take the next element.
5) If the element fits in the container, then go to step 3. If the element does not fit - go to step 2.
Algorithm "filling the first suitable"

A better algorithm that tries to minimize the number of containers while reducing the number of comparisons to find the best location.
1) We take a new element.
2) We take a new container.
3) Put the element in a container.
4) Take the next element.
5) If the element fits in the container, then go to step 3. If the element does not fit, check all the containers in turn, starting with the first. If you find a container with enough space for the cargo - go to step 3. If the cargo does not fit in any available container - go to step 2. The next active container (from which the test begins) it is advisable to choose the last number, because, potentially, he is the least filled.
Algorithm for filling in the "least complete"

The main idea of ​​the algorithm is the even distribution of goods in containers.
1) We take a new element.
2) We take a new container.
3) Put the element in a container.
4) Take the next element.
5) If the element fits in the container, then go to step 3. If the element does not fit in the container - check all containers for maximum free space. If the cargo fits in the minimally filled container - go to step 3, if not - to step 2. The next active container (from which the test begins) it is advisable to choose the last number, because, potentially, it is the least filled.
Algorithm for filling in the "best"

The main idea of ​​the algorithm is to create more fully filled containers.
1) We take a new element.
2) We take a new container.
3) Put the element in a container.
4) Take the next element.
5) If the element fits in the container, then go to step 3. If the element does not fit the container - check all the containers for a minimum of free space, but in which you can still put the load. If such a container is found - go to step 3, if not - to step 2. The next active container (from which the test begins) is selected last number.