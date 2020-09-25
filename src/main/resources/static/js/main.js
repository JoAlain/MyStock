$(document).ready(function(){

    $('.nArBtn, .table .eArBtn').on('click',function (event) {
        event.preventDefault();
        event.stopPropagation();
        var href = $(this).attr('href');
        var text = $(this).text();

        if(text != 'Nouveau'){
            var cat = $('.modalArticle #categorie');
            var scat = $('.modalArticle #souscategorie');
            var unit = $('.modalArticle #unite');
            $.get(href, function (entity, status) {
                $('.modalArticle #id').val(entity.id);
                $('.modalArticle #code').val(entity.code);
                $('.modalArticle #nomarticle').val(entity.nomarticle);
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

        if(text != 'Nouveau'){
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

        if(text != 'Nouveau'){
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

        if(text != 'Nouveau'){
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

        if(text != 'Nouveau'){

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

    $('.nEnBtn, .table .eEnBtn').on('click',function (event) {
        event.preventDefault();
        event.stopPropagation();
        var href = $(this).attr('href');
        var text = $(this).text();

        if(text != 'Nouveau'){

            var depot = $('.modalEntree #depot');
            var article = $('.modalEntree #article');
            $.get(href, function (entity, status) {
                $('.modalEntree #id').val(entity.id);
                $('.modalEntree #date').val(entity.date);
                $('.modalEntree #reference').val(entity.reference);
                $('.modalEntree #depot').val(entity.depot);
                $('.modalEntree #designation').val(entity.designation);
                $('.modalEntree #article').val(entity.article);
                $('.modalEntree #entree').val(entity.entree);
                $('.modalEntree #pu').val(entity.pu);

                $.get('/allArticle', function(arr){
                    $(arr).each(function() {
                        var selected = '';
                        if(entity.article = this.id){
                            selected = 'selected';
                        }
                        article.append($("<option>").attr('value',this.id).text(this.nomarticle)).attr('selected',selected);;
                    });
                });

                $.get('/allDepot', function(arr){
                    $(arr).each(function() {
                        var selected = '';
                        if(entity.depot = this.id){
                            selected = 'selected';
                        }
                        depot.append($("<option>").attr('value',this.id).text(this.libelle)).attr('selected',selected);;
                    });
                });
            });

            $('.modalEntree #exampleModal').modal();
        } else{
            var dep = $('.modalEntree #depot');
            var sel = $('.modalEntree #article');
            $('.modalEntree #id').val(0);
            $('.modalEntree #date').val('');
            $('.modalEntree #reference').val('');
            $('.modalEntree #designation').val('');
            $('.modalEntree #entree').val(1);
            $('.modalEntree #pu').val(0);

            $.get('/allArticle', function(article){
                var array = article;
                $(array).each(function() {
                    sel.append($("<option>").attr('value',this.id).text(this.nomarticle));
                });
            });

            $.get('/allDepot', function(depot){
                var array = depot;
                $(array).each(function() {
                    dep.append($("<option>").attr('value',this.id).text(this.libelle));
                });
            });

            $('.modalEntree #exampleModal').modal();
        }

    });

    $('.nSoBtn, .table .eSoBtn').on('click',function (event) {
        event.preventDefault();
        event.stopPropagation();
        var href = $(this).attr('href');
        var text = $(this).text();

        if(text != 'Nouveau'){

            var depot = $('.modalSortie #depot');
            var article = $('.modalSortie #article');
            $.get(href, function (entity, status) {
                $('.modalSortie #id').val(entity.id);
                $('.modalSortie #date').val(entity.date);
                $('.modalSortie #reference').val(entity.reference);
                $('.modalSortie #depot').val(entity.depot);
                $('.modalSortie #designation').val(entity.designation);
                $('.modalSortie #article').val(entity.article);
                $('.modalSortie #sortie').val(entity.sortie);
                $('.modalSortie #pu').val(entity.pu);

                $.get('/allArticle', function(arr){
                    $(arr).each(function() {
                        var selected = 'false';
                        if(entity.article.id === this.id){
                            selected = 'true';
                        }
                        article.append($("<option>").attr('value',this.id).text(this.nomarticle).attr('selected',selected));
                    });
                });

                $.get('/allDepot', function(arr){
                    $(arr).each(function() {
                        var selected = '';
                        if(entity.depot = this.id){
                            selected = 'selected';
                        }
                        depot.append($("<option>").attr('value',this.id).text(this.libelle)).attr('selected',selected);;
                    });
                });
            });

            $('.modalSortie #exampleModal').modal();
        } else{
            var dep = $('.modalSortie #depot');
            var sel = $('.modalSortie #article');
            $('.modalSortie #id').val(0);
            $('.modalSortie #date').val('');
            $('.modalSortie #reference').val('');
            $('.modalSortie #designation').val('');
            $('.modalSortie #sortie').val(1);
            $('.modalSortie #pu').val(0);

            $.get('/allArticle', function(article){
                var array = article;
                $(array).each(function() {
                    sel.append($("<option>").attr('value',this.id).text(this.nomarticle));
                });
            });

            $.get('/allDepot', function(depot){
                var array = depot;
                $(array).each(function() {
                    dep.append($("<option>").attr('value',this.id).text(this.libelle));
                });
            });

            $('.modalSortie #exampleModal').modal();
        }

    });

    $('.nTiersBtn, .table .eTiersBtn').on('click',function (event) {
        event.preventDefault();
        event.stopPropagation();
        var href = $(this).attr('href');
        var text = $(this).text();

        var typ = $('.modalTiers #type');
        if(text != 'Nouveau'){
            $.get(href, function (entity, status) {
                $('.modalTiers #id').val(entity.id);
                $('.modalTiers #nom').val(entity.nom);
                $('.modalTiers #adresse').val(entity.adresse);
                $('.modalTiers #email').val(entity.email);
                $('.modalTiers #phone').val(entity.phone);
                $('.modalTiers #nif').val(entity.nif);
                $('.modalTiers #stat').val(entity.stat);
                $('.modalTiers #gerant').val(entity.gerant);

                $.get('/allTypeTiers', function(arr){
                    $(arr).each(function() {
                        var selected = '';
                        if(entity.type = this.id){
                            selected = 'selected';
                        }
                        typ.append($("<option>").attr('value',this.id).text(this.libelle)).attr('selected',selected);;
                    });
                });
            });

            $('.modalTiers #exampleModal').modal();
        } else{
            $('.modalTiers #id').val(0);
            $('.modalTiers #nom').val('');
            $('.modalTiers #adresse').val('');
            $('.modalTiers #email').val('');
            $('.modalTiers #phone').val('');
            $('.modalTiers #nif').val('');
            $('.modalTiers #stat').val('');
            $('.modalTiers #gerant').val('');

            $.get('/allTypeTiers', function(depot){
                var array = depot;
                $(array).each(function() {
                    typ.append($("<option>").attr('value',this.id).text(this.libelle));
                });
            });
            $('.modalTiers #exampleModal').modal();
        }

    });

    $('.addStockBtn').on('click',function (event) {
        event.preventDefault();
        event.stopPropagation();
        var href = $(this).attr('href');

        $.get(href, function (entity, status) {
            $('.modalEntreeStock #id').val(0);
            $('.modalEntreeStock #date').val('');
            $('.modalEntreeStock #reference').val(entity.reference);
            $('.modalEntreeStock #depot').val(entity.depot.id);
            $('.modalEntreeStock #designation').val(entity.designation);
            $('.modalEntreeStock #article').val(entity.article.id);
            $('.modalEntreeStock #libelle').val(entity.article.nomarticle);
            $('.modalEntreeStock #dlibelle').val(entity.depot.libelle);
            $('.modalEntreeStock #reste').val(entity.reste);
            $('.modalEntreeStock #pu').val(entity.pu);
        });

        $('.modalEntreeStock #exampleModal').modal();
    });

    $('.nFClientBtn, .table .eFClientBtn').on('click',function (event) {
        event.preventDefault();
        event.stopPropagation();
        var href = $(this).attr('href');
        var text = $(this).text();

        var typ = $('.modalFClient #modepaiement');
        if(text != 'Nouveau'){
            $.get(href, function (entity, status) {
                $('.modalFClient #id').val(entity.id);
                $('.modalFClient #orderid').val(entity.orderid);
                $('.modalFClient #tiers').val(entity.tiers);
                $('.modalFClient #paiementdue').val(entity.paiementdue);
                $('.modalFClient #tva').val(entity.tva);

                $.get('/allModePaiement', function(arr){
                    $(arr).each(function() {
                        var selected = '';
                        if(entity.type = this.id){
                            selected = 'selected';
                        }
                        typ.append($("<option>").attr('value',this.id).text(this.libelle)).attr('selected',selected);;
                    });
                });

                $.get('/allClient', function(arr){
                    $(arr).each(function() {

                    });
                });


            });

            $('.modalFClient #exampleModal').modal();
        } else{
            $('.modalFClient #id').val(0);
            $('.modalFClient #orderid').val('');
            $('.modalFClient #tiers').val('');
            $('.modalFClient #paiementdue').val('');
            $('.modalFClient #tva').val(0);

            $.get('/allModePaiement', function(depot){
                var array = depot;
                $(array).each(function() {
                    typ.append($("<option>").attr('value',this.id).text(this.libelle));
                });
            });


            $('.modalFClient #exampleModal').modal();
        }

    });

    $('.nFcDetails, .table .eFClientDBtn').on('click',function (event) {
        event.preventDefault();
        event.stopPropagation();
        const href = $(this).attr('href');
        var text = $(this).text();
        console.log(text);
        if(text == 'Ajouter détails') {
            console.log('connard');
            $.get(href, function (entity, status) {
                $('.modalFClientDts #id').val(0);
                $('.modalFClientDts #facture').val(entity.id);
                $('.modalFClientDts #produit').val('');
                $('.modalFClientDts #description').val('');
                $('.modalFClientDts #quantite').val(1);
            });
        } else{
            $.get(href, function (entity, status) {
                $('.modalFClientDts #id').val(entity.id);
                $('.modalFClientDts #facture').val(entity.facture.id);
                $('.modalFClientDts #produit').val(entity.produit.id);
                $('.modalFClientDts #description').val(entity.description);
                $('.modalFClientDts #quantite').val(entity.quantite);
            });
        }

        $('.modalFClientDts #exampleModal').modal();
    });
});