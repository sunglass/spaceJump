$(function(){
    //ui caching here
    var filterInputTag = $("#inputTag");
    var filterAddedTags = $("#selectedTags");
    //end of caching here

    //Bind listeners here
    $("#goToCreationBox").click(function(){
        $("#filterBox").fadeOut(400, function(){
            $("#creationBox").fadeIn(400);
        });
    });

    $("#goToFilterBox").click(function(){
        $("#creationBox").fadeOut(400, function(){
            $("#filterBox").fadeIn(400);
        });
    });

    filterAddedTags.on("click",".tag",function(){
        $(this).remove();
    });

    //End of listeners

    var availableTags = [
        "ActionScript",
        "AppleScript",
        "Asp",
        "BASIC",
        "C",
        "C++",
        "Clojure",
        "COBOL",
        "ColdFusion",
        "Erlang",
        "Fortran",
        "Groovy",
        "Haskell",
        "Java",
        "JavaScript",
        "Lisp",
        "Perl",
        "PHP",
        "Python",
        "Ruby",
        "Scala",
        "Scheme"
    ];
    filterInputTag.autocomplete({
        source:availableTags
    });
    filterInputTag.on( "autocompleteselect", function( event, ui ) {
        var thisEl = $(this);
        var newTag = $("<label>").addClass("tag").html(ui.item.value);
        $("#selectedTags").append(newTag);
        $("#inputTag").val("").focus();
        return false;
    } );


});
