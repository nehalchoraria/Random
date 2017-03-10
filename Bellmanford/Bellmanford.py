# -*- coding: utf-8 -*-
"""
Created on Sun Feb 12 11:14:06 2017

@author: Nehal
"""
import numpy as np

with open('BellmanInput.txt') as f:
    data = f.readlines()
data=list(map(lambda x:x.strip(),data))
no_of_nodes=len(data)

Graph=[0]*no_of_nodes

for i in range(0,len(data)):
    Graph[i]=data[i].split(" ")          # Input matrix
Paths = [];

for i in range(0,no_of_nodes):
    for j in range(0,no_of_nodes):
        if((Graph[i][j]!="0")&(Graph[i][j]!="-")&(i!=j)):
            {
            Paths.append([i,j,Graph[i][j]]) # i --> u , j --> v , distance
          
            }    


for i in range(0,no_of_nodes):
    Source=i
    distance=np.zeros((2,no_of_nodes))    
    distance[0]=[i for i in range(no_of_nodes)]
    
    for i in range(0,no_of_nodes):
        if(distance[0][i]==Source):
            distance[1][i]=0
        else:
            distance[1][i]=np.inf               # Initializing Distance
        
    parent=np.zeros((2,no_of_nodes))
    parent[0]=[i for i in range(no_of_nodes)]
    
    for i in range(0,no_of_nodes):
        if(parent[0][i]==Source):
            distance[1][i]=0 
        else:
            distance[1][i]=np.inf              # Initializing parent
    
    for j in range(0,no_of_nodes-1):
        for i in range(0,len(Paths)):
            u=Paths[i][0]        
            v=Paths[i][1]
            n=(int)(Paths[i][2])
            if(distance[1][v] > distance[1][u]+n):        #Relaxing
                distance[1][v]=distance[1][u]+n
                parent[1][v]=u
    
    with open('BellmanOutput.txt', 'a') as f:
        print("For node",Source,file=f)
        for i in range(0,no_of_nodes):
            print("Shortest distance to",parent[0][i],"is",distance[1][i],file=f)
        print(file=f)
