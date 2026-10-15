package br.unipar.backend.trabalho2bi.repository;

import br.unipar.backend.trabalho2bi.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface VeiculoRepository
        extends JpaRepository<Veiculo, Integer>,
        JpaSpecificationExecutor<Veiculo> {

    List<Veiculo> findByMarca(String marca);

    List<Veiculo> findByAno(Integer ano);

    default List<Veiculo> pesquisa(String modelo, String marca, Integer ano) {

        return findAll((root, query, cb) -> {

            var filtros = new java.util.ArrayList<
                    jakarta.persistence.criteria.Predicate>();

            if (modelo != null && !modelo.isBlank()) {
                filtros.add(cb.equal(
                        cb.lower(root.get("modelo")),
                        modelo.toLowerCase(java.util.Locale.ROOT)
                ));
            }

            if (marca != null && !marca.isBlank()) {
                filtros.add(cb.equal(
                        cb.lower(root.get("marca")),
                        marca.toLowerCase(java.util.Locale.ROOT)
                ));
            }

            if (ano != null) {
                filtros.add(cb.equal(root.get("ano"), ano));
            }

            return cb.and(filtros.toArray(
                    new jakarta.persistence.criteria.Predicate[0]
            ));
        });
    }
}