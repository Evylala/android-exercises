package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import timber.log.Timber;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        // Plant logger cf. Android Timber
        Timber.plant(new Timber.DebugTree());

        // TODO build Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://henri-potier.xebia.fr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // TODO create a service
        HenriPotierService service = retrofit.create(HenriPotierService.class);
        Call<List<Book>> call = service.listBooks();
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Response<List<Book>> response, Retrofit retrofit) {
                for (Book book: response.body()) {
                    Timber.i(book.getTitle());
                }
            }
            @Override
            public void onFailure(Throwable t) {
            }
                // TO

        // TODO listBooks()


        // TODO enqueue call and display book title

        // TODO log books

        // TODO display book as a list
        });
    }
}


