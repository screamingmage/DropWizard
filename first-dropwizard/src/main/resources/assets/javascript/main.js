/**
 * Created with IntelliJ IDEA.
 * User: sully.rafiq
 * Date: 31/07/2014
 * Time: 20:59
 * To change this template use File | Settings | File Templates.
 */

$(function() {

    $(".item-save").on("click", function() {
        event.preventDefault();

        var data = {description : $(".item-description").val()}

        $.ajax({
            contentType:'application/json',
            data: JSON.stringify(data),
            dataType:'json',
            type: 'POST',
            url: "/todo/save"
        })
        .fail(function(xhr, textStatus, errorThrown) {
            console.log("Something went wrong with creating item: " + xhr.responseText + " " + errorThrown);
        })
        .done(function(date) {
            console.log("Saved item");
        });

    });
});