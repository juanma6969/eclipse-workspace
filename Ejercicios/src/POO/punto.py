'''
Created on 28 dic. 2020

@author: JuanManuel
'''
import math
class Punto(object):
  


    def __init__(self,x=0,y=0):
        self.x=x
        self.y=y   
        
    def mostrar(self):
        return str(self.x)+ ":" + str(self.y)
     
    def distancia(self,otro):
        dx=self.x - otro.x
        dy=self.y - otro.y
        return math.sqrt((dx*dx + dy*dy))