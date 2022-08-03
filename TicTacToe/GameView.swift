//
//  GameView.swift
//  TicTacToe
//
//  Created by Sadman Adib on 31/7/22.
//

import SwiftUI

struct GameView: View {
    
    @StateObject private var viewModel = GameViewModel()
    
    var body: some View {
        GeometryReader{ geometry in
            VStack {
                Spacer()
                
                LazyVGrid(columns: viewModel.columns, spacing: 5){
                    ForEach(0..<9){ item in
                        ZStack{
                            GameSquareView(proxy: geometry)
                            
                            PlayerIndicator(systemImageName: viewModel.moves[item]?.indicator ?? "")
                        }
                        .onTapGesture {
                            viewModel.processPlayerMove(for: item)
                        }
                    }
                }
                
                Spacer()
            }
            .disabled(viewModel.isGameboardDisabled)
            .padding()
            .alert(item: $viewModel.alertItem) { alertItem in
                Alert(title: alertItem.title, message: alertItem.message, dismissButton: .default(alertItem.buttonTitle, action: {
                    viewModel.resetGame()
                }))
            }
            
        }
    }
}

enum Player {
    case human, computer
}

struct Move {
    let player: Player
    let boardIndex: Int // it is where the player has made the move.
    
    var indicator: String {
        return player == .human ? "xmark" : "circle"
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        GameView()
    }
}

struct GameSquareView: View {
    
    var proxy: GeometryProxy
    
    var body: some View {
        Circle()
            .foregroundColor(.red)
            .opacity(0.5)
            .frame(width: proxy.size.width/3 - 15, height: proxy.size.width/3 - 15)
    }
}

struct PlayerIndicator: View {
    
    var systemImageName: String
    
    var body: some View {
        Image(systemName: systemImageName)
            .resizable()
            .frame(width: 40, height: 40)
            .foregroundColor(.white)
    }
}
