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
    
    @State private var moves: [Move?] = Array(repeating: nil, count: 9)
    @State private var isHumanTurn = true
    
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
                            
                            Image(systemName: moves[item]?.indicator ?? "")
                                .resizable()
                                .frame(width: 40, height: 40)
                                .foregroundColor(.white)
                        }
                        .onTapGesture {
                            if isSquareOccupied(in: moves, forIndex: item) { return }
                            moves[item] = Move(player: isHumanTurn ? .human : .computer, boardIndex: item)
                            isHumanTurn.toggle()
                        }
                    }
                }
                
                Spacer()
            }
            .padding()

        }
    }
}

func isSquareOccupied(in moves: [Move?], forIndex index: Int) -> Bool {
    return moves.contains(where: { $0?.boardIndex == index })
}

enum Player {
    case human, computer
}

struct Move {
    let player: Player
    let boardIndex: Int
    
    var indicator: String {
        return player == .human ? "xmark" : "circle"
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
