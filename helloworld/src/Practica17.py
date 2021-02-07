'''
Created on 27 dic. 2020

@author: JuanManuel
'''
hP=int(input("Hora de salida:"))
minP=int(input("minutos de salida:"))
segP=int(input("segundos de salida:"))
segV=int(input("Tiempo que ha tardado en llegar en seg :"))
#Convertir 
segP=hP*3600+minP*60+segP
segV=segP+segV
hP=segV//3600
minP=(segV%3600)//60
segP=(segV%3600)%60
print(hP,":",minP,":",segP)
