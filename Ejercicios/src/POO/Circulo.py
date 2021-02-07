'''
Created on 28 dic. 2020

@author: JuanManuel
'''

class Circulo(object):
    '''
    classdocs
    '''


    def __init__(self, radio):
      
       self.radio=radio
       
    @property
    def radio(self):
        print("Estoy dando radio")
        return self.__radio
    @radio.setter
    def radio(self,radio):
        if radio>=0:
            self.__radio= radio
        else:
            print("Radio debe ser positivo")
            self.__radio=0
            