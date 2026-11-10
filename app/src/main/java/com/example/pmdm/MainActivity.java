package com.example.pmdm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * UD 3.3 · Hilos.
 *
 * Un contador que va del 0 % al 100 %, un punto por segundo. Cada segundo de espera
 * (Thread.sleep(1000)) hace el papel de una tarea lenta: descargar un fichero, consultar un
 * servidor, procesar una foto...
 *
 * Hay tres versiones del contador. Se prueban de una en una, dejando sin comentar solo su
 * llamada en el botón Contar (TODO 3, 4 y 5).
 */
public class MainActivity extends AppCompatActivity {

    private Button botonContar;
    private Button botonCancelar;
    private TextView textoProgreso;

    // TODO 1. El hilo secundario se guarda en un atributo para poder pararlo desde el botón
    //  Cancelar y al destruir la actividad.
    private Thread hilo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonContar = findViewById(R.id.btn_contar);
        botonCancelar = findViewById(R.id.btn_cancelar);
        textoProgreso = findViewById(R.id.txt_progreso);

        botonContar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO 2. Mientras cuenta, Contar se desactiva y Cancelar se activa.
                botonContar.setEnabled(false);
                botonCancelar.setEnabled(true);

                // TODO 3. Versión 1: cuenta en el hilo principal. La aplicación se congela y, si
                //  tocas la pantalla, Android avisa de que no responde.
                //contarEnHiloPrincipal();

                // TODO 4. Versión 2: cuenta en un hilo secundario que cambia el texto él mismo.
                //  La aplicación se cierra con CalledFromWrongThreadException.
                //contarConHiloQueTocaLaVista();

                // TODO 5. Versión 3: cuenta en un hilo secundario y le pasa cada valor al hilo
                //  principal con runOnUiThread(). Es la que funciona.
                contarConRunOnUiThread();
            }
        });

        botonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO 6. Cancelar: interrupt() avisa al hilo. Si está dentro de sleep(), sleep()
                //  lanza InterruptedException y el hilo termina (TODO 10).
                if (hilo != null && hilo.isAlive()) {
                    hilo.interrupt();
                }
                restaurarBotones();
            }
        });
    }

    /**
     * Versión 1. Todo ocurre en el hilo principal, el mismo que dibuja la pantalla y atiende
     * los toques.
     */
    private void contarEnHiloPrincipal() {
        for (int i = 0; i <= 100; i++) {
            try {
                // TODO 7. sleep() duerme al hilo que lo ejecuta: aquí, al hilo principal. Mientras
                //  duerme no dibuja la pantalla ni atiende los botones, así que no se ve ningún
                //  número hasta el final y Cancelar no responde.
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
            textoProgreso.setText(i + "%");
        }
        restaurarBotones();
    }

    /**
     * Versión 2. La cuenta va en un hilo secundario, pero ese hilo cambia la vista directamente.
     */
    private void contarConHiloQueTocaLaVista() {
        hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        return;
                    }
                    // TODO 8. Solo el hilo principal puede tocar las vistas. Esta línea, ejecutada
                    //  desde el hilo secundario, cierra la aplicación con
                    //  CalledFromWrongThreadException.
                    textoProgreso.setText(i + "%");
                }
            }
        });
        hilo.start();
    }

    /**
     * Versión 3. El hilo secundario hace la espera y le pide al hilo principal que cambie la vista.
     */
    private void contarConRunOnUiThread() {
        // TODO 9. Se crea el hilo con un Runnable anónimo, como en PSP, y se arranca con start().
        hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO 10. Lo han interrumpido (Cancelar o salir de la pantalla): el hilo
                        //  termina saliendo de run().
                        return;
                    }

                    // TODO 11. Una clase anónima solo puede usar variables locales que no cambien.
                    //  i cambia en cada vuelta, así que se copia en una variable final.
                    final int porcentaje = i;

                    // TODO 12. runOnUiThread() deja el Runnable en la cola del hilo principal, que
                    //  lo ejecuta en cuanto puede. El hilo secundario no espera: sigue contando.
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textoProgreso.setText(porcentaje + "%");
                        }
                    });
                }

                // TODO 13. Al terminar, los botones también se cambian desde el hilo principal.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        restaurarBotones();
                    }
                });
            }
        });
        hilo.start();
    }

    private void restaurarBotones() {
        botonContar.setEnabled(true);
        botonCancelar.setEnabled(false);
    }

    // TODO 14. Al salir de la pantalla, o al girar el móvil, la actividad se destruye. El hilo no
    //  se para solo: se interrumpe aquí para que no siga contando para una pantalla que ya no está.
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (hilo != null) {
            hilo.interrupt();
        }
    }
}
