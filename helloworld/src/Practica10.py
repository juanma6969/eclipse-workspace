'''
Created on 27 dic. 2020

@author: JuanManuel
'''
print ("Nota final")
nO=float(input("Introduce la nota 1:"))
nT=float(input("Introduce la nota 2:"))
nTh=float(input("Introduce la nota 3:"))
nO=((nO+nT+nTh)/3)
nO*=0.55
nT=float(input("Introduce la examen  final :"))
nT*=0.3
nTh=float(input("Introduce el trabajo final :"))
nTh*=0.15
nO=nO+nT+nTh
print ("La nota es %.2f" %(nO))