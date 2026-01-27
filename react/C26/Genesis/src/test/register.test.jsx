
import {test, expect} from "vitest";
import Register from "../auth/Register/Register.jsx";
import { fireEvent, render, screen } from "@testing-library/react";

test("that input collects first name correctly", () => {
    render(<Register />);
    const input = screen.getByLabelText(/First Name/);
    fireEvent.change(input, { target: { value: "Daniel" } });
    expect(input.value).toBe("Daniel");
});