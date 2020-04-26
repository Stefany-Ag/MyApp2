package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String Nombre = "Nombre";
    public static final String Categoria = "Categoria";
    public static final String Duracion = "Duracion";
    public static final String ANIMES = "Anime";
    Spinner spinNombre, spinCategoria;
    ListView lvLista;
    MediaPlayer mp;
    ArrayList<Anime> animes = new ArrayList<Anime>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(this, R.raw.away);
        mp.start();
        lvLista = findViewById(R.id.lvLista);
        spinNombre = findViewById(R.id.spinNombre);
        spinCategoria = findViewById(R.id.spinCategoria);
        ArrayAdapter spinAdapter = ArrayAdapter.createFromResource(this,R.array.spinNombre,android.R.layout.simple_spinner_item);
        spinNombre.setAdapter(spinAdapter);
        ArrayAdapter spinAdapter2 = ArrayAdapter.createFromResource(this,R.array.spinCategoria,android.R.layout.simple_spinner_item);
        spinCategoria.setAdapter(spinAdapter2);
        String[][] datos = {{"100","Angel Beats!","Drama, Escolar","13 capítulos","Cuando Otonashi despierta en una escuela desconocida y sin recuerdos, la situación que tiene frente a él es completamente caótica: un grupo de estudiantes le dice que está muerto, que está en el más allá y que debe pelear si no quiere ser aniquilado. ¿El enemigo? Ángel, enviada de Dios y cuya misión es que estos jóvenes acepten sus injustas muertes."},
                {"101","Another","Gore, Terror","12 capítulos","La historia se centra en una clase maldita y en los hilos del destino que llevan hasta a la muerte a todos los alumnos de la misma. Hace 26 años iba a esa clase una chica llamada Misaki. Buena deportista, popular, le caía bien a todo el mundo, sacaba las mejores notas... Pero un día murió dejando un vacío enorme en sus compañeros de clases. Estos, decididos a no olvidarla, siguieron actuando como si Misaki siguiera viva hasta la graduación."},
                {"102","Clannad","Drama, Escolar","23 capítulos","Tomoya Okazaki es un joven de tercer año de instituto que parece importarle poco su desempeño escolar, y sumada a su actitud conflictiva originada por problemas familiares, es marcado como “delincuente” en su escuela por la gran mayoría de sus compañeros que están más ocupados pensando en lo que harán una vez acaben la escuela. Tomoya, sin amigos, oficio ni beneficio; conoce providencialmente a Nagisa Furukawa, una chica enfermiza algo lenta en los estudios que se quedó sin amigos puesto que todos ellos ya se habían graduado."},
                {"103","Dragon Ball Z","Shonen, Acción","291 capítulos","Continuando con la adaptación del manga, la serie narra la aventura de la vida adulta de Son Goku quien, con sus compañeros defiende la tierra contra varios villanos. Mientras que la serie original, Dragon Ball, narra la historia de la infancia hasta la adultez, Dragon Ball Z es la continuación de la vida adulta que lleva Goku, paralelamente narra la madurez de su hijo, Gohan."},
                {"104","Elfen Lied","Gore, Drama","13 capítulos","Lucy es una diclonius (humanoide mutante con poderes especiales y dos pequeños cuernos en la cabeza) que escapa del laboratorio donde la tienen encerrada. En su huida, es herida en la cabeza por la bala de un francotirador, cayendo al mar. Al poco es encontrada en una playa por Kohta y su prima Yuka, que la acogerán en su casa sin conocer su verdadera personalidad."},
                {"105","Fairy Tail","Shonen, Comedia","328 capítulos","Lucy Heartfilia es una joven decidida a unirse al gremio de magos Fairy Tail. En su recorrido conocerá a Natsu, que es parte del gremio y que le ofrece entrar a formar parte de sus filas. Una historia de amistad, superación, combates mágicos, humor y muchos retos que superar, siempre con mucha acción de por medio."},
                {"106","Full Metal Alchemist","Drama, Fantasía","51 capítulos","La historia se centra en los hermanos Edward y Alphonse Elric, quienes viven en un pequeño pueblo de un país ficticio llamado Amestris. Su padre, Hohenheim, se había marchado de su casa cuando aún eran pequeños y años más tarde su madre, Trisha Elric, muere por una enfermedad terminal, dejando a los hermanos Elric solos. Después de la muerte de su madre, Edward decide resucitarla a través de la alquimia, una de las técnicas científicas más avanzadas conocidas por el hombre."},
                {"107","Inuyasha","Drama, Fantasía","167 capítulos","La serie se da lugar mayormente en el Japón del Período Sengoku. En esa época, la adolescente proveniente del siglo XX, Kagome Higurashi se encuentra con Inuyasha, un hibrido que ansiaba poseer la perla de las cuatro almas para convertirse en un demonio de raza pura, pero que, al enterarse de que Kagome causó la fragmentación de ésta, debe aventurarse a recuperarla parte por parte. Ella decide acompañar a Inuyasha en la búsqueda de los fragmentos, por lo que deberá alternar entre una vida cotidiana en su época original y recuperar la perla durante un tiempo."},
                {"108","Kaichou wa Maid-Sama","Comedia, Romance","26 capítulos","La preparatoria Seika era un lugar sólo para hombres, pero recientemente se ha convertido en un colegio mixto, contando con apenas 20% de mujeres, ante un 80% de hombres. Allí, Misaki Ayuzawa toma en sus manos el poder, para hacer sentir seguras a las chicas, convirtiéndose en la presidenta del consejo estudiantil."},
                {"109","Nanatsu no Taizai","Shonen","24 capítulos","La princesa Elizabeth Liones huye de su hogar para ir en la búsqueda de los legendarios siete pecados capitales, por lo que usando una armadura oxidada Elizabeth vaga sin rumbo hasta que llega a una cantina llamada Boar's Hat donde conoce al dueño Meliodas, un joven que aparenta ser un adolescente y que tiene un poder mágico oculto y a Hawk un cerdo con la particular habilidad de hablar."},
                {"110","Nisekoi","Comedia, Romance","20 capítulos","En su pasado Raku conoció a una joven chica, que le regaló un collar en forma de candado prometiendo reencontrarse y abrir juntos aquel collar, para revelar qué hay adentro. En la actualidad, Raku estudia con Shuu Maiko y Kosaki Onodera, de la cual sospecha es la chica que en su infancia le dio aquel collar."}
        };
        int[] imagen = {R.drawable.AngelBeats,R.drawable.Another,R.drawable.Clannad,R.drawable.DBZ,R.drawable.ElfenLied,R.drawable.FairyTail,R.drawable.FullMetalA,R.drawable.Inuyasha,R.drawable.Kaichou,R.drawable.NanatsuNoTaizai,R.drawable.Nisekoi};
        for(int i = 0; i < 10; i++){
            Anime temporal = new Anime (""+ i,Nombre + i, Categoria + i, Duracion + i);
            animes.add(temporal);
        }
        Adapter adaptador = new Adapter(this, datos, imagen);
        lvLista.setAdapter(adaptador);
        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "ID: " + id, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(ANIMES,animes);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        spinNombre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    protected void onPause(){
        super.onPause();
        mp.pause();
    }

    protected void onRestart(){
        super.onRestart();
        mp.start();
    }

    protected void onStop(){
        super.onStop();
        mp.stop();
    }

}
