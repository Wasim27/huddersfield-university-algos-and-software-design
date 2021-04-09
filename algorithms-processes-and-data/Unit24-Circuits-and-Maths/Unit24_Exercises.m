a = 4 + 1i;
b = -2 + 6i;

i = 3*a %question i
ii = -4i*b %question ii
iii = a+b %question iii
iv = a-b %question iv
v = a*b %question v
vi = a/b %question vi
vii = abs(a) %question vii
viii = abs(b) %question viii

A = [ 
    0 -4  3  0 
    1 2  0 -2 
    0 -3  1 -1];
 
B = [
  1 -4  0  0  2
  0 -1  3 -2  0
  1  1  1  0 -1
  0  2 -3  3  4];

ix = 3*A %question ix
x = -5*B %question x
xi = A*B %question xi
xii = kron(A,B) %question xii
  
C = [
  0     3+2i  2-4i
    2i -3+ 1i -4-3i];

xiii = transpose(C) %question xiii
xiv = conj(C) %question xiv
xv = transpose(conj(C)) %question xv
 
NOT = [
0 1
1 0];

FALSE = [1;0];

ZERO = FALSE;

TRUE = [0;1];

ONE = TRUE;

AND = [1,1,1,0;0,0,0,1];

xvi = kron(ONE,ONE) %question xvi
xvii = NOT*FALSE == ONE %question xvii
xviii = AND*kron(ONE,ONE) %question xviii
xviiiTwo = kron(ZERO,ONE) %question xviiiTwo
xix = [1,0,0,0;0,1,1,1]; %question xix
xx = NOT*xix %question xx


