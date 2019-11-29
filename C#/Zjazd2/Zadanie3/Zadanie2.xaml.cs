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
    /// Logika interakcji dla klasy Zadanie2.xaml
    /// </summary>
    public partial class Zadanie2 : Window
    {
        public Zadanie2()
        {
            InitializeComponent();

        }

        private void Zamknij(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void Lista_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            TextBoxMethod.Text =((ComboBoxItem)Lista.SelectedItem).Content.ToString();
        }
    }
}
