package com.example.proyecto.service;

import com.example.proyecto.dto.DTOPago;
import com.example.proyecto.entity.Pago;
import com.example.proyecto.repository.RPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SPago {

    @Autowired
    private RPago rPago;

    public List<DTOPago> obtenerTodosDTO() {
        List<Pago> pagos = rPago.findAll();
        return pagos.stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    public DTOPago obtenerPorIdDTO(Long id) {
        Optional<Pago> optionalPago = rPago.findById(id);
        return optionalPago.map(this::convertirADTO).orElse(null);
    }

    public DTOPago guardarDTO(DTOPago dtoPago) {
        Pago pago = new Pago();
        pago.setValor(dtoPago.getValor());
        pago.setBanco(dtoPago.getBanco());
        pago.setNumCuenta(dtoPago.getNumCuenta());

        pago = rPago.save(pago);
        return convertirADTO(pago);
    }

    public DTOPago actualizarDTO(Long id, DTOPago dtoPago) {
        Optional<Pago> optionalPago = rPago.findById(id);
        if (optionalPago.isPresent()) {
            Pago pago = optionalPago.get();
            pago.setValor(dtoPago.getValor());
            pago.setBanco(dtoPago.getBanco());
            pago.setNumCuenta(dtoPago.getNumCuenta());

            pago = rPago.save(pago);
            return convertirADTO(pago);
        }
        return null;
    }

    public void eliminarDTO(Long id) {
        rPago.deleteById(id);
    }

    private DTOPago convertirADTO(Pago pago) {
        DTOPago dtoPago = new DTOPago();
        dtoPago.setId(pago.getId());
        dtoPago.setValor(pago.getValor());
        dtoPago.setBanco(pago.getBanco());
        dtoPago.setNumCuenta(pago.getNumCuenta());

        return dtoPago;
    }
}
