package vn.iotstar.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import vn.iotstar.enity.Category;

// T là entity, ID là kiểu dữ liệu của khoá chính.
public interface CategoryRepository extends JpaRepository<Category, Long> {
	Optional<Category> findByName(String name);

	Page<Category> findByNameContaining(String name, Pageable pageable);
}
