using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace Zadanie3
{
    /// <summary>
    /// Logika interakcji dla klasy Zadanie3i4.xaml
    /// </summary>
    public partial class Zadanie3i4 : Window
    {
        List<Student> list1;

        public Zadanie3i4()
        {
            list1 = new List<Student>();
            InitializeComponent();

            var st1 = new Student
            {
                Imie = "Roman",
                Nazwisko = "Giertych",
                Nrindeksu= "202"
            };
            var st2 = new Student
            {
                Imie = "Magda",
                Nazwisko = "Niezdana",
                Nrindeksu = "666"
            };
      
            list1.Add(st1);
            list1.Add(st2);
            StudentsGrid.ItemsSource = list1;
      
        }
        private void addData(string t1, string t2, string t3)
        {
            var student = new Student
            {
                Imie = t1,
                Nazwisko = t2,
                Nrindeksu = t3
            };

            list1.Add(student);
            StudentsGrid.Items.Refresh();
        }

        private void Dodaj_Click(object sender, RoutedEventArgs e)
        {
            Regex reg = new Regex(@"s([0-9]{4})");
            Match match = reg.Match(indeksBox.Text);

            if (match.Success)
            {
                addData(imieBox.Text, nazwiskoBox.Text, indeksBox.Text);
            }
            else
            {
                Console.WriteLine("Nieprawidlowy nr indeksu");
            }
        }

        private void Usun_Click(object sender, RoutedEventArgs e)
        {
            list1.Remove((Student)StudentsGrid.SelectedItem);
            StudentsGrid.Items.Refresh();
        }

        private void StudentsGrid_MouseDoubleClick(object sender, MouseButtonEventArgs e)
        {
            Student selectedStudent = (Student)StudentsGrid.SelectedItem;
            var window = new StudentEditDialog(selectedStudent);
            window.Show();
        }
    }
}
