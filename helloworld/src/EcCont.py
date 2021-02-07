'''
Created on 27 dic. 2020

@author: JuanManuel
'''
cont = 0;
for var in range(1,6):
    num = int(input("Dime un número:"))
    if num % 2 == 0:
        cont = cont + 1
print("Has introducido ",cont," números pares.")