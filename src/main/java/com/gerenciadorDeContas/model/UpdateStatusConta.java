package com.gerenciadorDeContas.model;

import com.gerenciadorDeContas.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStatusConta {

    private Status status;
}
