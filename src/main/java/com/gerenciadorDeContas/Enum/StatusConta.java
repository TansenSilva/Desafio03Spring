package com.gerenciadorDeContas.Enum;

import com.gerenciadorDeContas.model.ContasModel;
import java.time.LocalDate;
import static com.gerenciadorDeContas.Enum.Status.*;
public class StatusConta {
    public Status statusConta(ContasModel conta){
        LocalDate dataDeHoje = LocalDate.now();
        if(conta.getDataDeVencimento().isBefore(dataDeHoje)){
          return VENCIDA;
        } else {
            return AGUARDANDO;
        }
    }
}
