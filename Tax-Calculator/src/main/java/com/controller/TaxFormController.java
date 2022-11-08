package com.controller;
import com.domain.TaxForm;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/tax")
public class TaxFormController {
    private DataSource dataSource;

    public TaxFormController(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/form")
    public String createForm(Model model) {
        model.addAttribute("taxForm", new TaxForm());
        return "taxFile/form";
    }
    @RequestMapping("/submit")
    public String create(@Valid @ModelAttribute("taxForm") TaxForm taxForm, BindingResult bindingResult, Model model) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "taxFile/form";
        } else {
            int category = taxForm.getTax_payer_category();
            int zone = taxForm.getTax_payer_zone();
            int basic_salary = taxForm.getBasic_salary();
            int house_rent = taxForm.getHouse_rent();
            int house_rent_sal = (int) (basic_salary * 0.5);
            int house_rent_act = 25000 * 12;
            int house_rent_cal = Math.min(house_rent_sal, house_rent_act);
            int house_rent_taxable;
            if (house_rent - house_rent_cal < 0) {
                house_rent_taxable = Math.round(0);
            } else {
                house_rent_taxable = Math.round(house_rent - house_rent_cal);
            }


            int medical = taxForm.getMedical();
            int medical_sal = (int) (basic_salary * 0.1);
            int medical_act = 120000;
            int medical_cal = Math.min(medical_sal, medical_act);
            int medical_taxable;
            if (medical - medical_cal < 0) {
                medical_taxable = Math.round(0);
            } else {
                medical_taxable = Math.round(medical - medical_cal);
            }

            int conveyance = taxForm.getConveyance();
            int conveyance_sal = 30000;
            int conveyance_act = 30000;
            int conveyance_cal = Math.min(conveyance_sal, conveyance_act);
            int conveyance_taxable;
            if (conveyance - conveyance_cal < 0) {
                conveyance_taxable = Math.round(0);
            } else {
                conveyance_taxable = Math.round(conveyance - conveyance_cal);
            }
            int commission = taxForm.getCommission();
            int bonus = taxForm.getBonus();
            int investment = taxForm.getInvestment();

            int TotalIncome = basic_salary + house_rent + medical + conveyance + commission + bonus;
            int TotalTaxableIncome = basic_salary + house_rent_taxable + medical_taxable + conveyance_taxable + commission + bonus;

            model.addAttribute("TotalIncome", TotalIncome);
            model.addAttribute("TotalTaxableIncome", TotalTaxableIncome);

            int tax1, tax2, tax3, tax4, tax5, tax6;

            if (category == 1) {
                if (Math.round(TotalTaxableIncome) > 300000) {
                    tax1 = 300000;
                } else {
                    tax1 = Math.round(TotalTaxableIncome);
                }

                if (Math.round(TotalTaxableIncome) > 400000) {
                    tax2 = 100000;
                } else {
                    if (TotalTaxableIncome - 300000 < 0) {
                        tax2 = Math.round(0);
                    } else {
                        tax2 = Math.round(TotalTaxableIncome - 300000);
                    }
                }

                if (Math.round(TotalTaxableIncome) > 700000) {
                    tax3 = 300000;
                } else {
                    if (TotalTaxableIncome - 400000 < 0) {
                        tax3 = Math.round(0);
                    } else {
                        tax3 = Math.round(TotalTaxableIncome - 400000);
                    }
                }

                if (Math.round(TotalTaxableIncome) > 1100000) {
                    tax4 = 400000;
                } else {
                    if (TotalTaxableIncome - 700000 < 0) {
                        tax4 = Math.round(0);
                    } else {
                        tax4 = Math.round(TotalTaxableIncome - 700000);
                    }
                }

                if (Math.round(TotalTaxableIncome) > 1600000) {
                    tax5 = 500000;
                } else {
                    if (TotalTaxableIncome - 1100000 < 0) {
                        tax5 = Math.round(0);
                    } else {
                        tax5 = Math.round(TotalTaxableIncome - 1100000);
                    }
                }

                if (Math.round(TotalTaxableIncome) > 1600000) {
                    tax6 = Math.round(TotalTaxableIncome - 1600000);
                } else {
                    tax6 = Math.round(0);
                }
            } else if (category == 2) {
                if (Math.round(TotalTaxableIncome) > 350000) {
                    tax1 = 350000;
                } else {
                    tax1 = Math.round(TotalTaxableIncome);
                }
                if (Math.round(TotalTaxableIncome) > 450000) {
                    tax2 = 100000;
                } else {
                    if (TotalTaxableIncome - 350000 < 0) {
                        tax2 = Math.round(0);
                    } else {
                        tax2 = Math.round(TotalTaxableIncome - 350000);
                    }
                }
                if (Math.round(TotalTaxableIncome) > 750000) {
                    tax3 = 300000;
                } else {
                    if (TotalTaxableIncome - 450000 < 0) {
                        tax3 = Math.round(0);
                    } else {
                        tax3 = Math.round(TotalTaxableIncome - 450000);
                    }
                }
                if (Math.round(TotalTaxableIncome) > 1150000) {
                    tax4 = 400000;
                } else {
                    if (TotalTaxableIncome - 750000 < 0) {
                        tax4 = Math.round(0);
                    } else {
                        tax4 = Math.round(TotalTaxableIncome - 750000);
                    }
                }
                if (Math.round(TotalTaxableIncome) > 1650000) {
                    tax5 = 500000;
                } else {
                    if (TotalTaxableIncome - 1150000 < 0) {
                        tax5 = Math.round(0);
                    } else {
                        tax5 = Math.round(TotalTaxableIncome - 1150000);
                    }
                }

                if (Math.round(TotalTaxableIncome) > 1650000) {
                    tax6 = Math.round(TotalTaxableIncome - 1650000);
                } else {
                    tax6 = Math.round(0);
                }
            } else if (category == 3) {

                if (Math.round(TotalTaxableIncome) > 450000) {
                    tax1 = 450000;
                } else {
                    tax1 = Math.round(TotalTaxableIncome);
                }

                if (Math.round(TotalTaxableIncome) > 550000) {
                    tax2 = 100000;
                } else {
                    if (TotalTaxableIncome - 450000 < 0) {
                        tax2 = Math.round(0);
                    } else {
                        tax2 = Math.round(TotalTaxableIncome - 450000);
                    }
                }

                if (Math.round(TotalTaxableIncome) > 850000) {
                    tax3 = 300000;
                } else {
                    if (TotalTaxableIncome - 550000 < 0) {
                        tax3 = Math.round(0);
                    } else {
                        tax3 = Math.round(TotalTaxableIncome - 550000);
                    }
                }

                if (Math.round(TotalTaxableIncome) > 1250000) {
                    tax4 = 400000;
                } else {
                    if (TotalTaxableIncome - 850000 < 0) {
                        tax4 = Math.round(0);
                    } else {
                        tax4 = Math.round(TotalTaxableIncome - 850000);
                    }
                }

                if (Math.round(TotalTaxableIncome) > 1750000) {
                    tax5 = 500000;
                } else {
                    if (TotalTaxableIncome - 1250000 < 0) {
                        tax5 = Math.round(0);
                    } else {
                        tax5 = Math.round(TotalTaxableIncome - 1250000);
                    }
                }

                if (Math.round(TotalTaxableIncome) > 1750000) {
                    tax6 = Math.round(TotalTaxableIncome - 1750000);
                } else {
                    tax6 = Math.round(0);
                }
            } else {
                if (Math.round(TotalTaxableIncome) > 475000) {
                    tax1 = 475000;
                } else {
                    tax1 = Math.round(TotalTaxableIncome);
                }

                if (Math.round(TotalTaxableIncome) > 575000) {
                    tax2 = 100000;
                } else {
                    if (TotalTaxableIncome - 475000 < 0) {
                        tax2 = Math.round(0);
                    } else {
                        tax2 = Math.round(TotalTaxableIncome - 475000);
                    }
                }
                if (Math.round(TotalTaxableIncome) > 875000) {
                    tax3 = 300000;
                } else {
                    if (TotalTaxableIncome - 575000 < 0) {
                        tax3 = Math.round(0);
                    } else {
                        tax3 = Math.round(TotalTaxableIncome - 575000);
                    }
                }

                if (Math.round(TotalTaxableIncome) > 1275000) {
                    tax4 = 400000;
                } else {
                    if (TotalTaxableIncome - 875000 < 0) {
                        tax4 = Math.round(0);
                    } else {
                        tax4 = Math.round(TotalTaxableIncome - 875000);
                    }
                }
                if (Math.round(TotalTaxableIncome) > 1775000) {
                    tax5 = 500000;
                } else {
                    if (TotalTaxableIncome - 1275000 < 0) {
                        tax5 = Math.round(0);
                    } else {
                        tax5 = Math.round(TotalTaxableIncome - 1275000);
                    }
                }
                if (Math.round(TotalTaxableIncome) > 1775000) {
                    tax6 = Math.round(TotalTaxableIncome - 1775000);
                } else {
                    tax6 = Math.round(0);
                }
            }
            int Tax = (int) Math.round(tax1 * 0 + tax2 * 0.05 + tax3 * 0.1 + tax4 * 0.15 + tax5 * 0.2 + tax6 * 0.25);

            model.addAttribute("TotalTax", Tax);

            int AllowableInvestment = (int) (TotalTaxableIncome * 0.25);
            int Rebate, Investment, netTax;
            if (investment > AllowableInvestment) {
                Investment = AllowableInvestment;
            } else {
                Investment = investment;
            }

            if (TotalIncome > 15000000) {
                Rebate = (int) Math.round(Investment * 0.15);
            } else {
                Rebate = Math.round(0);
            }

            if (zone == 1) {
                if (Tax - Rebate < 5001) {
                    if (TotalTaxableIncome < 300000) {
                        netTax = 0;
                    } else {
                        netTax = 5000;
                    }
                } else {
                    netTax = Math.round(Tax - Rebate);
                }
            } else if (zone == 2) {
                if (Tax - Rebate < 4001) {
                    if (TotalTaxableIncome < 300000) {
                        netTax = 0;
                    } else {
                        netTax = 4000;
                    }
                } else {
                    netTax = Math.round(Tax - Rebate);
                }
            } else if (zone == 3) {
                if (Tax - Rebate < 3001) {
                    if (TotalTaxableIncome < 300000) {
                        netTax = 0;
                    } else {
                        netTax = 3000;
                    }
                } else {
                    netTax = Math.round(Tax - Rebate);
                }
            } else {
                netTax = Tax;
            }

            model.addAttribute("AllowableInvestment", AllowableInvestment);
            model.addAttribute("Investment", Investment);
            model.addAttribute("netTax", netTax);

            LocalDateTime date = LocalDateTime.now();
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into tax_info (category, zone, salary, rent, medical, conveyance, commission, bonus, investment, tax, allowable_investment, netTax  ) " +
                                                                          "values (?, ?,?,?,?,?,?,?,?,?,?,?)");
            statement.setInt(1, taxForm.getTax_payer_category());
            statement.setInt(2, taxForm.getTax_payer_zone());
            statement.setInt(3, taxForm.getBasic_salary());
            statement.setInt(4, taxForm.getHouse_rent());
            statement.setInt(5, taxForm.getMedical());
            statement.setInt(6, taxForm.getConveyance());
            statement.setInt(7, taxForm.getCommission());
            statement.setInt(8, taxForm.getBonus());
            statement.setInt(9, taxForm.getInvestment());
            statement.setInt(10, Tax);
            statement.setInt(11, AllowableInvestment);
            statement.setInt(12, netTax);
            statement.execute();

            return "taxFile/form";
        }
    }
}
