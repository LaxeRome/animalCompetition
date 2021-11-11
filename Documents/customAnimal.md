# How To Make A Custom Animal

  

## In this example we will be configuring a dragon animal.

  

### Where To Configure:

The first thing you need to know is all configurations of the animal are done in the console.

  

### Naming The Animal:

The second thing you have to do is give the animal a name. The name of the animal does not effect any part of the program, so feel free to name it whatever you like!

For Example,
```console
Animal: dragon
```

  

### Setting Up Speed:

Thirdly, what you need to do is input the speed of the animal, the strength of the animal, and the weight of the animal all on one line separated by a space. For example,

```console
Input speed, strength, weight: 6 16 111
```

if you want to find out how to increase or decrease speed, please refer to [speedAlgorithm.md](https://github.com/LaxeRome/animalCompetition/blob/main/Documents/speedAlgorithm.md)  
  
If your speed value is less than or equal to one, then the health bar will appear to be stuck at full.

### Setting Up Defense:

Once you have the speed finished you now have to configure the defensive stats of the custom animal. This part is pretty simple. If you want your animal to take no damage, you set the defense to 0. If you want your animal to take normal amount of damage, set the defense value to 1. If you want the animal to take more damage, have the defensive value be greater than 1.  
For example,

```console
Defense: 0.75
```
Since the defense is less than 1, the overall damage taken is reduced by 0.75x (more durable). If it were over 1, then damage taken would be increased by (whatever number). (Less durable) 
### Setting Up Attack:
Setting up the attack value is very simple. The user can input any number they wish, as attack is the real damage that you do to other animals. For example, 100 attack does less damage than 150 attack.
```console
Attack: 150
```
### Setting Up Stamina
Great! Now you have almost everything complete! All that is left to do is set your stamina. This value can be anything you wish, as long as it is greater than 0. 
```console
Stamina: 10000
```
#### Now you've got yourself a custom dragon animal configured just to your liking! Just sit back, relax and find out what configuration works the best for you! 