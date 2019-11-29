using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
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
    /// Logika interakcji dla klasy StudentEditDialog.xaml
    /// </summary>
    public partial class StudentEditDialog : Window
    {
        public StudentEditDialog(Student student)
        {
            InitializeComponent();

            imie.AppendText(student.Imie);
            
            nazwisko.AppendText(student.Nazwisko);
            nrIndeksu.AppendText(student.Nrindeksu);


        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            this.Close();
        }
    }
}
