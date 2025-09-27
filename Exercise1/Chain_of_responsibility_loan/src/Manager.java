public class Manager implements LoanApprover {
    private LoanApprover next;

    @Override
    public void setNextApprover(LoanApprover next) {
        this.next = next;
    }

    @Override
    public void approveLoan(LoanApplication loan) {
        if (loan.getAmount() <= 200000) {
            System.out.println("Manager approved loan of ₹" + loan.getAmount() +
                               " for " + loan.getApplicantName());
        } else if (next != null) {
            next.approveLoan(loan);
        } else {
            System.out.println("❌ No approver found for " + loan.getApplicantName());
        }
    }
}
