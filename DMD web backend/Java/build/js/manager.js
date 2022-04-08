function selectAll(t) {
    var checkbox = $('table tbody input[type="checkbox"]');
    $(t).click(function () {
        if (this.checked) {
            checkbox.each(function () {
                this.checked = true;
            });
        } else {
            checkbox.each(function () {
                this.checked = false;
            });
        }
    });
    checkbox.click(function () {
        if (!this.checked) {
            $(t).prop("checked", false);
        }
    });
}