'''
Created on 27 dic. 2020

@author: JuanManuel
'''
#-*- coding: utf-8 -*-
secret="asdasd"
key=input("Dime la clave : ")
while key != secret:
    print("Clave incorrecta")
    resp=input("¿Quieres introducir otra clave (S/N)? :")
    if resp.upper() == "N":
        break;
    key = input("Dime la clave")
if key == secret:
    print("Bienvenido!!!")
print("Programa terminado")
