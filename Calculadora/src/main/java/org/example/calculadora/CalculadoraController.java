package org.example.calculadora;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CalculadoraController {
    @FXML
    private TextField tela;
    @FXML private String  valorAtual;


    @FXML
    private void btnNumero0() {
        tela.setText(valorAtual=tela.getText()+"0");
    }
    @FXML
    private void btnNumero1() {tela.setText(valorAtual=tela.getText()+"1");}
    @FXML
    private void btnNumero2() {
        tela.setText(valorAtual=tela.getText()+"2");
    }
    @FXML
    private void btnNumero3() {
        tela.setText(valorAtual=tela.getText()+"3");
    }
    @FXML
    private void btnNumero4() {
        tela.setText(valorAtual=tela.getText()+"4");
    }
    @FXML
    private void btnNumero5() {
        tela.setText(valorAtual=tela.getText()+"5");
    }
    @FXML
    private void btnNumero6() {
        tela.setText(valorAtual=tela.getText()+"6");
    }
    @FXML
    private void btnNumero7() {
        tela.setText(valorAtual=tela.getText()+"7");
    }
    @FXML
    private void btnNumero8() {
        tela.setText(valorAtual=tela.getText()+"8");
    }
    @FXML
    private void btnNumero9() {tela.setText(valorAtual=tela.getText()+"9");}
    @FXML
    private void btnPonto() {tela.setText(valorAtual=tela.getText()+".");}
    @FXML
    private void btnSomar() {tela.setText(valorAtual=tela.getText()+"+");}
    @FXML
    private void btnSubtrair() {tela.setText(valorAtual=tela.getText()+"-");}
    @FXML
    private void btnMultiplicar() {tela.setText(valorAtual=tela.getText()+"*");}
    @FXML
    private void btnDividir() {tela.setText(valorAtual=tela.getText()+"/");}

    @FXML
    private void btnIgual() {
        try {
            String expr = tela.getText();

            Expression expressao = new ExpressionBuilder(expr).build();
            double resultado = expressao.evaluate();

            if (resultado == (long) resultado) {
                tela.setText(String.valueOf((long) resultado));
            } else {
                tela.setText(String.valueOf(resultado));
            }

            valorAtual = tela.getText();

        } catch (Exception e) {
            tela.setText("Erro");
        }
    }

}
