// JavaScript for managing categories

document.addEventListener("DOMContentLoaded", function() {
    const deleteButtons = document.querySelectorAll(".delete-btn");

    deleteButtons.forEach(button => {
        button.addEventListener("click", function(event) {
            if (!confirm("Bạn có chắc chắn muốn xóa danh mục này?")) {
                event.preventDefault();
            }
        });
    });
});
