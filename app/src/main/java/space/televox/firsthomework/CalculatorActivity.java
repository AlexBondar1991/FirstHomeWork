package space.televox.firsthomework;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class CalculatorActivity extends AppCompatActivity {

    private EditText calculation, result; // обьявляем две приватные переменные ->область вычыслений и результата
    private String curr, res; // обьявляем две приватные переменные -> текущяя кнопка и результат операции
    /*
    При нажатии на кнопки с цифрами переменная curr будет передаваться в переменную calculation и отображаться в calculationZone
    Результат из переменной res передаем в переменную result и он будет отображаться в resultZone
     */


    private Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero, btnAC, btnDel, btnDivision, btnMultiplication, btnSubtraction, btnAdd,
            btnEqual, btnDot; // обьявляем переменную типа Button для всех кнопок на нашей активити


    private boolean dotInserted, operatorInserted; // создаем переменные типа boolean для правильного выведения точки на экране


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_activity);

        calculation = (EditText) findViewById(R.id.calculationZone); // инициализируем переменную и кастуем ее в тип EditText
        result = (EditText) findViewById(R.id.resultZone); // инициализируем переменную и кастуем ее в тип EditText

        curr = ""; // присваиваем переменной curr значение пустой строки
        res = ""; // присваиваем переменной curr значение пустой строки

        dotInserted = false; // присваиваем переменной dotInserted значение false
        operatorInserted = false; // присваиваем переменной operatorInserted значение false


        // инициализируем все кнопки  на калькуляторе -> начало
        btnZero = (Button) findViewById(R.id.btnZero);
        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnFour = (Button) findViewById(R.id.btnFour);
        btnFive = (Button) findViewById(R.id.btnFive);
        btnSix = (Button) findViewById(R.id.btnSix);
        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnEight = (Button) findViewById(R.id.btnEight);
        btnNine = (Button) findViewById(R.id.btnNine);
        btnAC = (Button) findViewById(R.id.btnAC);
        btnDel = (Button) findViewById(R.id.btnDelete);
        btnDivision = (Button) findViewById(R.id.btnDivide);
        btnMultiplication = (Button) findViewById(R.id.btnMultiply);
        btnSubtraction = (Button) findViewById(R.id.btnMinus);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnEqual = (Button) findViewById(R.id.btnAnswer);
        btnDot = (Button) findViewById(R.id.btnDot);
        // инициализируем все кнопки  на калькуляторе -> конец


        // Устанавливаем слушатель в объект каждой кнопки с помощью метода ​setOnClickListener() -> начало

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "0"; // присваиваем значение текущей кнопке значение ->  curr + "0"
                displayOne(); // выводим в calculatedZone значение текущей кнопки
            }
        });

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "1";
                displayOne();
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "2";
                displayOne();
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "3";
                displayOne();
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "4";
                displayOne();
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "5";
                displayOne();
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "6";
                displayOne();
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "7";
                displayOne();
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "8";
                displayOne();
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "9";
                displayOne();
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // в случае если строка пустая и пользователь ввел точку -> добавляем к ней ноль "0.",
                // присваиваем переменной dotInserted значение true
                if (curr.isEmpty()) {
                    curr = "0.";
                    dotInserted = true;
                }

                // если переменная dotInserted == false -> добавляем "."
                if (dotInserted == false) {
                    curr = curr + ".";
                    dotInserted = true;
                }
                displayOne(); // через метод выводим полученные данные в calculationZone
            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // кнопка полной очистки содержимого начало
                clear(); // вызываем метод полной очистки
                displayOne(); // вызываем метод отображения в calculationZone
                displayTwo(); // вызываем метод отображения в resultZone
            }
            // кнопка полной очистки содержимого конец
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // кнопка удаления последнего введенного элемента начало
                backspase();
                displayOne();
            }
            // кнопка удаления последнего введенного элемента конец
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // сразу присваиваем dorInsert false чтобы была возможность поставить точку после введенного числа
                dotInserted = false;

                //если  curr не пустая
                if (!curr.isEmpty()) {

                    // если последнее число точка -> удаляем точку
                    if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                        backspase();
                    }

                    // если operatorInserted == false -> добавляем operator в curr
                    if (operatorInserted == false) {
                        curr = curr + " ÷ ";
                        operatorInserted = true; // присваиваем operatorInserted значение true во избежание повторного введения оператора
                    }
                }
                // displayOne
                displayOne();
            }
        });


        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // сразу присваиваем dorInsert false чтобы была возможность поставить точку после введенного числа
                dotInserted = false;

                //если  curr не пустая
                if (!curr.isEmpty()) {
                    // если последнее число точка -> удаляем точку
                    if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                        backspase();
                    }

                    // если operatorInserted == false -> добавляем operator в curr
                    if (operatorInserted == false) {
                        curr = curr + " * ";
                        operatorInserted = true;
                    }

                }


                // displayOne
                displayOne();
            }
        });


        btnSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // сразу присваиваем dorInsert false чтобы была возможность поставить точку после введенного числа
                dotInserted = false;

                //если  curr не пустая
                if (!curr.isEmpty()) {
                    // если последнее число точка -> удаляем точку
                    if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                        backspase();
                    }

                    // если operatorInserted == false -> добавляем operator в curr
                    if (operatorInserted == false) {
                        curr = curr + " - ";
                        operatorInserted = true;
                    }

                }


                // displayOne
                displayOne();
            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // сразу присваиваем dorInsert false чтобы была возможность поставить точку после введенного числа
                dotInserted = false;

                //если  curr не пустая
                if (!curr.isEmpty()) {
                    // если последнее число точка -> удаляем точку
                    if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                        backspase();
                    }

                    // если operatorInserted == false -> добавляем operator в curr
                    if (operatorInserted == false) {
                        curr = curr + " + ";
                        operatorInserted = true;
                    }

                }


                // displayOne
                displayOne();
            }
        });


        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // если последнее введеное значение не оператор
                if (operatorInserted = true && !curr.substring(curr.length() - 1, curr.length()).equals(" ")) {

                    String[] tokens = curr.split(" "); // создаем массив знаков инициализируя его через метод split который разделяет строку
                    // и возвращает массив строк

                    switch (tokens[1].charAt(0)) { // через оператор switch проверяем первый индекс и конвертим в символ через метод charAt

                        case '+':
                            res = Double.toString(Double.parseDouble(tokens[0]) + Double.parseDouble(tokens[2]));
                            break;
                        case '-':
                            res = Double.toString(Double.parseDouble(tokens[0]) - Double.parseDouble(tokens[2]));
                            break;
                        case '*':
                            res = Double.toString(Double.parseDouble(tokens[0]) * Double.parseDouble(tokens[2]));
                            break;
                        case '÷':
                            res = Double.toString(Double.parseDouble(tokens[0]) / Double.parseDouble(tokens[2]));
                            break;

                    }

                    displayTwo();
                }
            }
        });
        // Устанавливаем слушатель в объект каждой кнопки с помощью метода ​setOnClickListener() -> конец


    }

    // метод для отображенния введенных символов в calculationZone ->  начало
    public void displayOne() {
        calculation.setText(curr);
    }
    // метод для отображенния введенных символов в calculationZone ->  конец

    // метод для отображенния введенных символов в resultZone ->  начало
    public void displayTwo() {
        result.setText(res);
    }
    // метод для отображенния введенных символов в resultZone ->  конец

    // метод для полной очистки введенных символов -> начало
    public void clear() {
        curr = "";
        res = "";
        dotInserted = false;
        operatorInserted = false;
    }
    // метод для полной очистки введенных символов -> конец

    // метод для удаления последнего введенного символа -> начало
    public void backspase() {

        // если curr не пустая -> удаляем последний введенный элемент
        if (!curr.isEmpty()) {

            // если точка последний символ в строке -> если да, присваиваем  dotInserted = false
            if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                dotInserted = false;
            }

            // если оператор введен -> удаляем три последних значения из curr
            // & и  operatorInserted присваиваем false
            if (curr.substring(curr.length() - 1, curr.length()).equals(" ")) {
                curr = curr.substring(0, curr.length() - 3);
                operatorInserted = false;
            } else {
                curr = curr.substring(0, curr.length() - 1); // через метод substring возвращаем переменной curr новую строку минус 1 элемент
            }


        }
    }
    // метод для удаления последнего введенного символа -> конец


}
