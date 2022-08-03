//
//  GameViewModel.swift
//  TicTacToe
//
//  Created by Sadman Adib on 2/8/22.
//

import SwiftUI

final class GameViewModel: ObservableObject {
    
    let columns = [GridItem(.flexible()),
                   GridItem(.flexible()),
                   GridItem(.flexible())]
    
    @Published var moves: [Move?] = Array(repeating: nil, count: 9)
    @Published var isGameboardDisabled = false
    @Published var alertItem: AlertItem?
    
    func processPlayerMove(for item: Int){
        if isSquareOccupied(in: moves, forIndex: item) { return }
        moves[item] = Move(player: .human, boardIndex: item)
        
        //check for win or draw
        if checkWinCondition(for: .human, in: moves) {
            alertItem = AlertContext.humanWin
            return
        }
        
        if checkForDraw(in: moves) {
            alertItem = AlertContext.draw
            return
        }
        
        isGameboardDisabled = true
        
        DispatchQueue.main.asyncAfter(deadline: .now() + 0.5) { [self] in
            let computerPosition = determineComputerMovePosition(moves: moves)
            moves[computerPosition] = Move(player: .computer, boardIndex: computerPosition)
            isGameboardDisabled = false
            
            if checkWinCondition(for: .computer, in: moves) {
                alertItem = AlertContext.computerWin
                return
            }
            
            if checkForDraw(in: moves) {
                alertItem = AlertContext.draw
                return
            }
        }
    }
    
    func resetGame() {
        moves = Array(repeating: nil, count: 9)
    }
    
    func isSquareOccupied(in moves: [Move?], forIndex index: Int) -> Bool {
        return moves.contains(where: { $0?.boardIndex == index })
    }

    func determineComputerMovePosition(moves: [Move?]) -> Int {
        //If AI can win then win
        let winPattern: Set<Set<Int>> = [[0,1,2], [3,4,5], [6,7,8], [0,3,6], [1,4,7], [2,5,8], [0,4,8], [2,4,6]]
        
        let computerMoves = moves.compactMap{$0}.filter{$0.player == .computer}
        let computerPositions = Set(computerMoves.map{$0.boardIndex})
        
        for pattern in winPattern {
            let winPositions = pattern.subtracting(computerPositions)
            
            if winPositions.count == 1 {
                let isAvailable = !isSquareOccupied(in: moves, forIndex: winPositions.first!)
                if isAvailable { return winPositions.first!}
            }
        }
        
        //If AI can't win then block
        let humanMoves = moves.compactMap{$0}.filter{$0.player == .human}
        let humanPositions = Set(humanMoves.map{$0.boardIndex})
        
        for pattern in winPattern {
            //suppose humanPositions is [3,4,7,8]
            let winPositions = pattern.subtracting(humanPositions) // for the win pattern [3,4,5] the winPositions will be 5 after subtracting 3 and 4.
            
            
            if winPositions.count == 1 {
                let isAvailable = !isSquareOccupied(in: moves, forIndex: winPositions.first!)
                if isAvailable { return winPositions.first!}
            }
        }
        
        //If AI can't block, then take the middle square
        let centerSquare = 4
        if !isSquareOccupied(in: moves, forIndex: 4) {
            return centerSquare
        }
        
        
        //If AI can't take middle square, take random avaiable square
        var movePosition = Int.random(in: 0..<9)
        
        while isSquareOccupied(in: moves, forIndex: movePosition){
            movePosition = Int.random(in: 0..<9)
        }
        
        return movePosition
    }

    func checkWinCondition(for player: Player, in moves : [Move?]) -> Bool {
        let winPattern: Set<Set<Int>> = [[0,1,2], [3,4,5], [6,7,8], [0,3,6], [1,4,7], [2,5,8], [0,4,8], [2,4,6]]
        
        let playerMoves = moves.compactMap{$0}.filter{$0.player == player} // gives all the non-nill moves of the player that we pass in.
        let playerPosition = Set(playerMoves.map{$0.boardIndex}) // eg: gives [0,1,8]
        
        for pattern in winPattern where pattern.isSubset(of: playerPosition) { return true }

        return false
    }

    func checkForDraw(in moves: [Move?]) -> Bool {
        return moves.compactMap{$0}.count == 9
    }

    
}
