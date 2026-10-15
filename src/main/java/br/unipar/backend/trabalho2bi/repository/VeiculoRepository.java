package br.unipar.backend.trabalho2bi.repository;

import br.unipar.backend.trabalho2bi.model.Veiculo;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer>, JpaSpecificationExecutor<Veiculo> {

    List<Veiculo> findByMarca(String marca);

    List<Veiculo> findByAno(Integer ano);

    default List<Veiculo> pesquisa(String modelo, String marca, Integer ano) {
        return findAll((root, query, cb) -> {
            List<Predicate> filtros = new ArrayList<>();

            if (modelo != null && !modelo.isBlank()) {
                filtros.add(cb.equal(cb.lower(root.get("modelo")), modelo.toLowerCase(Locale.ROOT)));
            }

            if (marca != null && !marca.isBlank()) {
                filtros.add(cb.equal(cb.lower(root.get("marca")), marca.toLowerCase(Locale.ROOT)));
            }

            if (ano != null) {
                filtros.add(cb.equal(root.get("ano"), ano));
            }

            return cb.and(filtros.toArray(new Predicate[0]));
        });
    }
}
