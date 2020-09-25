$(document).ready(function(){

    $('.nArBtn, .table .eArBtn').on('click',function (event) {
        event.preventDefault();
        event.stopPropagation();
        var href = $(this).attr('href');
        var text = $(this).text();

        if(text == 'Modifier'){
            var cat = $('.modalArticle #categorie');
            var scat = $('.modalArticle #souscategorie');
            var unit = $('.modalArticle #unite');
            $.get(href, function (entity, status) {
                $('.modalArticle #id').val(entity.id);
                $('.modalArticle #code').val(entity.code);
                $('.modalArticle #nomarticle').val(entity.nomarticle);
                //$('.modalArticle #categorie').val(entity.categorie.id);
                //$('.modalArticle #souscategorie').val(entity.souscategorie.id);
                $('.modalArticle #prix').val(entity.prix);
                $('.modalArticle #unite').val(entity.unite);
                $('.modalArticle #creation').val(entity.creation);

                $.get('/allcategorie', function(array){
                    $(array).each(function() {
                        var selected = '';
                        if(entity.categorie = this.id){
                            selected = 'selected';
                        }
                        cat.append($("<option>").attr('value',this.id).text(this.libelle)).attr('selected',selected);
                    });
                });

                $.get('/allScategorie', function(arr){
                    $(arr).each(function() {
                        var selected = '';
                        if(entity.souscategorie = this.id){
                            selected = 'selected';
                        }
                        scat.append($("<option>").attr('value',this.id).text(this.libelle)).attr('selected',selected);;
                    });
                });

                $.get('/allUnite', function(array){
                    $(array).each(function() {
                        unit.append($("<option>").attr('value',this.id).text(this.libelle));
                    });
                });

            });

            $('.modalArticle #exampleModal').modal();
        } else{
            $('.modalArticle #id').val(0);
            $('.modalArticle #libelle').val('');
            //$('.modalArticle #description').val('');

            $('.modalArticle #exampleModal').modal();

            var cat = $('.modalArticle #categorie');
            var scat = $('.modalArticle #souscategorie');
            var unit = $('.modalArticle #unite');

            $.get('/allcategorie', function(array){
                $(array).each(function() {
                    cat.append($("<option>").attr('value',this.id).text(this.libelle));
                });
            });

            $.get('/allScategorie', function(arr){
                $(arr).each(function() {
                    scat.append($("<option>").attr('value',this.id).text(this.libelle));
                });
            });

            $.get('/allUnite', function(array){
                $(array).each(function() {
                    unit.append($("<option>").attr('value',this.id).text(this.libelle));
                });
            });

        }

    });

    $('.nBtn, .table .eBtn').on('click',function (event) {
        event.preventDefault();
        event.stopPropagation();
        var href = $(this).attr('href');
        var text = $(this).text();

        if(text == 'Modifier'){
            $.get(href, function (unite, status) {
                $('.modalUnite #id').val(unite.id);
                $('.modalUnite #libelle').val(unite.libelle);
                $('.modalUnite #description').val(unite.description);
            });

            $('.modalUnite #exampleModal').modal();
        } else{
            $('.modalUnite #id').val(0);
            $('.modalUnite #libelle').val('');
            $('.modalUnite #description').val('');

            $('.modalUnite #exampleModal').modal();
        }

    });

    $('.nDepBtn, .table .eDepBtn').on('click',function (event) {
        event.preventDefault();
        event.stopPropagation();
        var href = $(this).attr('href');
        var text = $(this).text();

        if(text == 'Modifier'){
            $.get(href, function (unite, status) {
                $('.modalDepot #id').val(unite.id);
                $('.modalDepot #libelle').val(unite.libelle);
                $('.modalDepot #description').val(unite.description);
            });

            $('.modalDepot #exampleModal').modal();
        } else{
            $('.modalDepot #id').val(0);
            $('.modalDepot #libelle').val('');
            $('.modalDepot #description').val('');

            $('.modalDepot #exampleModal').modal();
        }

    });

    $('.nCatBtn, .table .eCatBtn').on('click',function (event) {
        event.preventDefault();
        event.stopPropagation();
        var href = $(this).attr('href');
        var text = $(this).text();

        if(text == 'Modifier'){
            $.get(href, function (unite, status) {
                $('.modalCategorie #id').val(unite.id);
                $('.modalCategorie #libelle').val(unite.libelle);
                $('.modalCategorie #description').val(unite.description);
            });

            $('.modalCategorie #exampleModal').modal();
        } else{
            $('.modalCategorie #id').val(0);
            $('.modalCategorie #libelle').val('');
            $('.modalCategorie #description').val('');

            $('.modalCategorie #exampleModal').modal();
        }

    });

    $('.nSCatBtn, .table .eSCatBtn').on('click',function (event) {
        event.preventDefault();
        event.stopPropagation();
        var href = $(this).attr('href');
        var text = $(this).text();

        var arr = [
            {val : 1, text: 'One'},
            {val : 2, text: 'Two'},
            {val : 3, text: 'Three'}
        ];

        if(text == 'Modifier'){

            $.get(href, function (unite, status) {
                $('.modalSousCategorie #id').val(unite.id);
                $('.modalSousCategorie #libelle').val(unite.libelle);



                $('.modalSousCategorie #categorie').val(unite.categorie.id);
                $('.modalSousCategorie #description').val(unite.description);
            });

            $('.modalSousCategorie #exampleModal').modal();
        } else{
            var sel = $('.modalSousCategorie #categorie');
            $('.modalSousCategorie #id').val(0);
            $('.modalSousCategorie #libelle').val('');

            $.get('/allcategorie', function(categorie){
                var array = categorie;
                $(array).each(function() {
                    sel.append($("<option>").attr('value',this.id).text(this.libelle));
                });
            });

            //$('.modalSousCategorie #categorie').val('');
            $('.modalSousCategorie #description').val('');

            $('.modalSousCategorie #exampleModal').modal();
        }

    });


});