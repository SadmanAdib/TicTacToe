//
//  Alerts.swift
//  TicTacToe
//
//  Created by Sadman Adib on 2/8/22.
//

import SwiftUI

struct AlertItem: Identifiable {
    let id = UUID ()
    var title: Text
    var message: Text
    var buttonTitle: Text
}

struct AlertContext {
    
    static let humanWin = AlertItem(title: Text("You Won!"), message: Text("You successfully beat the AI"), buttonTitle: Text("Play Again"))
    
    static let computerWin = AlertItem(title: Text("You Lost"), message: Text("The AI beat you bad!"), buttonTitle: Text("Play Again"))
    
    static let draw = AlertItem(title: Text("Draw"), message: Text("The match is drawn"), buttonTitle: Text("Try Again"))
}
