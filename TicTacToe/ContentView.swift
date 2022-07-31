//
//  ContentView.swift
//  TicTacToe
//
//  Created by Sadman Adib on 31/7/22.
//

import SwiftUI

struct ContentView: View {
    
    let columns = [GridItem(.flexible()),
                   GridItem(.flexible()),
                   GridItem(.flexible())]
    
    var body: some View {
        GeometryReader{ geometry in
            VStack {
                Spacer()
                
                LazyVGrid(columns: columns, spacing: 5){
                    
                    ForEach(0..<9){ item in
                        ZStack{
                            Circle()
                                .foregroundColor(.red)
                                .opacity(0.5)
                                .frame(width: geometry.size.width/3 - 15, height: geometry.size.width/3 - 15)
                            
                            Image(systemName: "xmark")
                                .resizable()
                                .frame(width: 40, height: 40)
                                .foregroundColor(.white)
                        }
                    }
                }
                
                Spacer()
            }
            .padding()

        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
