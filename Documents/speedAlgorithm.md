# WARNING

## The following document contains the answer to the speed algorithm.

### The Speed Equation:

#### Regular Animal:
Ns = SFCs - WG

#### Air Type Animal:
Ns = T(SFCs - WG)

#### Water Type Animal:
Ns = D(SFCs - WG)

### What Are These Variables?
Ns = New Speed.  
D = Water Debuff. (When environment has no water.)  
T = Terrain Debuff. (When environment terrain is more complex.)  
S = Strength.  
F = Friction.  
Cs = Current Speed.  
W = Weight.  
G = Gravity. 

### Some Clarification:
If you want to make the animal get hit less, then you would increase the weight of the animal. With this you have to be extra careful though, because the animal will dodge every attack **unless the difference between the negatives and the positives is greater than two**.  
    
  The equation is made on a pretty simple idea. The Strength, friction, and current speed are all negative effects that increase your speed. If you want to have a better or worse speed, then you should change the strength, or the current speed of the animal. The friction cannot be changed as it is part of the current environment you are fighting in.  
    
  If you want to make the animal get hit less, then you would increase the weight of the animal. With this you have to be extra careful though, because if the difference between the negatives and the positives isn't greater than two, the animal will dodge every attack.