var TagManager = function(){
    this.tags = [];
    this.addTag = function(tag){
        var indx = this.getTagIndex(tag);
        if(indx < 0) {
            this.tags.push(tag);
            return this.tags.length;
        }
        return 0;
    };
    this.getTagIndex = function(tag) {
        return this.tags.indexOf(tag);
    };
    this.removeTag = function(tag) {
        var indx = this.getTagIndex(tag);
        if(indx >= 0) {
            this.tags.splice(indx,1);
        }
    };
    this.resetTag = function(){
        this.tags.length =  0;
    }
};
$(function(){
    //ui caching here
    var filterInputTag = $("#inputTag");
    var filterAddedTags = $("#selectedTags");

    var filterTags = new TagManager();
    //end of caching here

    //Bind listeners here
    $("#goToCreationBox").click(function(){
        $("#filterBox").fadeOut(400, function(){
            $("#creationBox").fadeIn(400);
        });
        resetFields();
    });

    $("#goToFilterBox").click(function(){
        $("#creationBox").fadeOut(400, function(){
            $("#filterBox").fadeIn(400);
        });
    });

    $("textarea[maxlength]").on("keyup blur", function(e) {
        var maxlength = $(this).attr('maxlength');
        var val = $(this).val();
        if(maxlength) {
            // Trim the field if it has content over the maxlength.
            if (val.length >= maxlength) {
                $(this).val(val.slice(0, maxlength));
            }
        }
    });

    filterAddedTags.on("click",".tag",function(){
        var thisEl = $(this);
        var tagName = thisEl.attr("tagName"), index;
        if(tagName) {
           filterTags.removeTag(tagName);
        }
        $(this).remove();
        filterCards();
    });

    //End of listeners

    $("#contentBox").isotope({
        itemSelector:".cardItemBox",
        layoutMode: "masonry",
        filter:"*"
    });

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
        var newTagVal = ui.item.value;
        if(filterTags.addTag(newTagVal)) {
            var newTag = $("<label>").addClass("tag").html(newTagVal).attr("tagName",newTagVal);
            $("#selectedTags").append(newTag);
            filterCards();
        }
        thisEl.val("").focus();
        return false;
    } );

    var clearFilterTags = function(){
        filterTags.reset();
        $("#selectedTags").find(".tags").remove();
    };

    var filterCards = function(){
        var filterString = "*";
        if(filterTags.tags.length > 0) {
            filterString = "." + filterTags.tags.join(".");
        }
        $("#contentBox").isotope({filter:filterString });
    };
    filterCards();

    var resetFields = function(){
        $("#descriptionBox").val("");
        $("#linkBox").val("");
        $("#tagBox").val("");
    }
});
